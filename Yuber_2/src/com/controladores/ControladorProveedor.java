package com.controladores;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.datatypes.*;
import com.entities.Cliente;
import com.entities.InstanciaServicio;
import com.entities.Proveedor;
import com.entities.Reseña;
import com.entities.Servicio;
import com.entities.Usuario;
import com.utils.ControlErrores;
import com.webservices.ControladorProveedorWS;

public class ControladorProveedor implements ControladorProveedorWS {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Yuber_2");
	EntityManager em = emf.createEntityManager();
	ControlErrores Error = new ControlErrores();
	
	public ControladorProveedor() {
	}
	
	@Override
	public String AceptarServicio(int InstanciaServicioId, String Correo){
		em.getTransaction().begin();
		Proveedor prov;
		try{
			prov = (Proveedor)em.find(Proveedor.class, Correo);
			em.flush();
			if(prov == null){
				return Error.P52;
			}
		}catch(Exception e){
			return Error.P52;
		}	
		if(!prov.isTrabajando()){
			return Error.P51;
		}
		//Busco la InstanciaServicio 		
		InstanciaServicio is;
		try{
			is = (InstanciaServicio)em.find(InstanciaServicio.class, InstanciaServicioId);
			if(is == null){
				return Error.I52;
			}
		}catch(Exception e){
			return Error.I52;
		}
		em.flush();
		//Asocio al provedor dicha InstanciaServicio
		if (is.getProveedor() == null){
			prov.addInstanciaServicio(is);
			em.getTransaction().commit();
			return Error.Ok;
		}else{
			return Error.I50;			
		}
	}
	
	@Override
	public String AsociarServicio(String ProveedorCorreo, int ServicioId){
		//Busco el servicio
		em.getTransaction().begin();
		Servicio Servicio;
		try{
			Servicio = (Servicio)em.find(Servicio.class, ServicioId);
			em.flush();
			if(Servicio == null){
				return Error.S2;
			}
		}catch(Exception e){
			return Error.S2;
		}
		//Busco al proveedor que lo solicito
		Proveedor prov;
		try{
			prov = (Proveedor)em.find(Proveedor.class, ProveedorCorreo);
			em.flush();
			if(prov == null){
				return Error.P52;
			}
		}catch(Exception e){
			return Error.P52;
		}					
		//Guardo el BD				
		prov.setServicio(Servicio);
		List<Proveedor> ListaProveedores = Servicio.getProveedores();
		ListaProveedores.add(prov);
		Servicio.setProveedores(ListaProveedores);				
		em.persist(prov);
		em.getTransaction().commit();		
		return Error.Ok;
	}
	
	@Override
	public String FinalizarJornada(String ProveedorCorreo, int ServicioId){		
		em.getTransaction().begin();
		//Busco al Proveedor
		Proveedor prov;
		try{
			prov = (Proveedor)em.find(Proveedor.class, ProveedorCorreo);
			em.flush();
			if(prov == null){
				return Error.P52;
			}
		}catch(Exception e){
			return Error.P52;
		}	
		if(prov.isTrabajando()){
			if(prov.getServicio().getServicioId() == ServicioId){
				prov.setTrabajando(false);
				em.persist(prov);
				em.getTransaction().commit();				
			}
			else{
				return Error.P50;
			}
		}
		return Error.Ok;
	}
	
	@Override
	public String FinServicio(int InstanciaServicioId, float Distancia){
		em.getTransaction().begin();		
		InstanciaServicio InstanciaServicio;
		try{
			InstanciaServicio = (InstanciaServicio)em.find(InstanciaServicio.class, InstanciaServicioId);
			if(InstanciaServicio == null)
			{
				return Error.I52;
			}
		}catch(Exception e){
			return Error.I52;
		}
		em.flush();
		if(InstanciaServicio.getInstanciaServicioFechaFin() != null){
			return Error.I53;
		}
		//Calculo el tiempo
		java.util.Date fechaFin = new Date();
		java.util.Date fechaInicio = InstanciaServicio.getInstanciaServicioFechaInicio();
		float Tiempo = ( fechaFin.getTime() - fechaInicio.getTime() )/1000; 
		float Costo = 0;
		float TarifaBase = InstanciaServicio.getServicio().getServicioTarifaBase();
		String TipoDeVertical = InstanciaServicio.getServicio().getVertical().getVerticalTipo();
		//Calculo la tarifa
		if (TipoDeVertical.equals("Transporte")){
			//La tarifa, estará determinada como: tarifa_base + distancia_recorrida * precio_por_km
			float PrecioPorKM = InstanciaServicio.getServicio().getServicioPrecioKM();
			Costo = TarifaBase + (Distancia*PrecioPorKM);			
		}else{
			//tarifa_base + tiempo * precio_por_hora
			float PrecioPorHora = InstanciaServicio.getServicio().getServicioPrecioHora();
			float PrecioPorSegundo = PrecioPorHora/60/60;			
			Costo = TarifaBase + (Tiempo*PrecioPorSegundo);
		}					
		//Seteo y guardo
		InstanciaServicio.setInstanciaServicioCosto(Costo);
		InstanciaServicio.setInstanciaServicioDistancia(Distancia);
		InstanciaServicio.setInstanciaServicioTiempo(Tiempo);
		InstanciaServicio.setInstanciaServicioFechaFin(fechaFin);
		//Guardo el BD
		em.persist(InstanciaServicio);
		em.getTransaction().commit();
		return Error.Ok;
	}
			
	public String IniciarJornada(String ProveedorCorreo, int ServicioId){		
		em.getTransaction().begin();
		//Busco al Proveedor
		Proveedor prov;
		try{
			prov = em.find(Proveedor.class, ProveedorCorreo);
			em.flush();
			if(prov == null){
				return Error.P52;
			}
		}catch(Exception e){
			return Error.P52;
		}	
		if(!prov.isTrabajando()){
			if(prov.getServicio().getServicioId() == ServicioId){
				prov.setTrabajando(true);
				em.persist(prov);
				em.getTransaction().commit();				
			}else{
				return Error.P50;
			}
		}
		return Error.Ok;
	}
	
	@Override
	public String IniciarServicio(int InstanciaServicioId){
		java.util.Date fecha = new Date();
		//Busco la InstanciaServicio 
		em.getTransaction().begin();
		InstanciaServicio is;
		try{
			is = (InstanciaServicio)em.find(InstanciaServicio.class, InstanciaServicioId);
			if(is == null){
				return Error.I52;
			}
		}catch(Exception e){
			return Error.I52;
		}
		em.flush();
		//Asocio la fecha a la InstanciaServicio
		is.setInstanciaServicioFechaInicio(fecha);
		em.persist(is);
		em.getTransaction().commit();
		return Error.Ok;
	}
	
	@Override
	public void Login(String ProveedorEmail, String Password){		
	}
	
	public List<DataInstanciaServicio> ObtenerHistorial(String ProveedorCorreo){		
		List<DataInstanciaServicio> ListaDataInstanciaServicio = new ArrayList<DataInstanciaServicio>();		
		Query query = em.createNamedQuery("ObtenerHistorial", InstanciaServicio.class).setParameter("CorreoProv", ProveedorCorreo);
		List<InstanciaServicio> ListaInstanciaServicio = query.getResultList();
		for (InstanciaServicio InstanciaServicio : ListaInstanciaServicio){ 
			DataInstanciaServicio DataInstanciaServicio = InstanciaServicio.getDataInstanciaServicio();
			ListaDataInstanciaServicio.add(DataInstanciaServicio);
		}
		return ListaDataInstanciaServicio;
	}
	
	public List<DataProveedor> ObtenerProveedores(){	
		List<DataProveedor> ListaDataProveedor = new ArrayList<DataProveedor>();
		List<Proveedor> ListaProveedor = em.createQuery(
				"SELECT u FROM Proveedor u", Proveedor.class).getResultList();
		for (Proveedor Proveedor : ListaProveedor){ 
			DataProveedor dc = Proveedor.getDataProveedor();
			ListaDataProveedor.add(dc);
		}
		return ListaDataProveedor;
	}
	
	@Override
	public boolean OlvidePass(String ClienteCorreo){
		//************************ESTA INCOMPETO************************//
		//Retorna true si lo manda false en otro caso		
	    String para = ClienteCorreo;
	    String de = "martinperez_15@hotmail.com";
	    String host = "localhost";
	    Properties propiedades = System.getProperties();
	    propiedades.setProperty("mail.smtp.host", host);
	    Session sesion = Session.getDefaultInstance(propiedades);
		try{
			MimeMessage mensaje = new MimeMessage(sesion);
			mensaje.setFrom(new InternetAddress(de));
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(para));
			mensaje.setSubject("Recuperación de la contraseña");
			Random rnd = new Random();
			int n = 100000 - 999999 + 1;
			int pass = rnd.nextInt() % n;
			String msgInicio = "<h1>YUBER</h1><br><p>La contraseña nueva para su cuenta es: '";
			String msgFin = "'. <br> ¡Gracias por utilizar el servicio!</p>";
			mensaje.setContent(msgInicio + pass + msgFin,"text/html");
			Transport.send(mensaje);
			//Cambio en la BD la pass			
			em.getTransaction().begin();
			Proveedor prov = (Proveedor)em.find(Proveedor.class, ClienteCorreo);
			em.flush();
			prov.setUsuarioContraseña(String.valueOf(pass));			
			em.getTransaction().commit();
			return true;
		} catch (MessagingException e) {
			return false;
		}
	}
	
	public String PuntuarProveedor(int Puntaje, String Comentario, int InstanciaServicioId){	
		em.getTransaction().begin();		
		//Busco la InstanciaServicio 		
		InstanciaServicio InstanciaServicio;
		try{
			InstanciaServicio = (InstanciaServicio)em.find(InstanciaServicio.class, InstanciaServicioId);
			if(InstanciaServicio == null)
			{
				return Error.I52;
			}
		}catch(Exception e){
			return Error.I52;
		}
		em.flush();
		//Creo reseña para el cliente para dicha InstanciaServicio
		Reseña Reseña = new Reseña();
		Reseña.setInstanciaServicio(InstanciaServicio);
		Reseña.setReseñaComentario(Comentario);
		Reseña.setReseñaPuntaje(Puntaje);		
		InstanciaServicio.setReseñaProveedor(Reseña);
		//Guardo el BD
		em.persist(InstanciaServicio);
		em.getTransaction().commit();		
		String Error = RecalcularPromedio(InstanciaServicio.getProveedor());		
		return Error;
	}
	
	private String RecalcularPromedio(Proveedor Proveedor)	{
		try{
			List<InstanciaServicio> ListaInstancias = Proveedor.getInstanciasServicio();
			float suma = 0;
			int cantidad = 0;
			for(InstanciaServicio is : ListaInstancias){
				suma += is.getReseñaProveedor().getReseñaPuntaje();
				cantidad++;
			}			
			float promedio = suma/cantidad;
			Proveedor.setUsuarioPromedioPuntaje(promedio);
			em.getTransaction().begin();;
			em.persist(Proveedor);
			em.getTransaction().commit();		
			return Error.Ok;
		}catch(Exception e){
			return Error.P53;
		}
	}
	
	public void RechazarServicio(int InstanciaServicioId){
		//Creo que no tiene que hacer nada. Lo unico que hace esto es el cancel en el boton 
		//del celular ignorando el servicio que se le habia propuesto
	}
	
	public void RegistrarProveedor(DataProveedor Proveedor){
		Proveedor user = new Proveedor();
		user.setUsuarioNombre(Proveedor.getUsuarioNombre());
		user.setUsuarioApellido(Proveedor.getUsuarioApellido());
		user.setUsuarioCiudad(Proveedor.getUsuarioCiudad());
		user.setUsuarioContraseña(Proveedor.getUsuarioContraseña());
		user.setUsuarioCorreo(Proveedor.getUsuarioCorreo());
		user.setUsuarioDireccion(Proveedor.getUsuarioDireccion());		
		user.setUsuarioPromedioPuntaje(0);
		user.setUsuarioTelefono(Proveedor.getUsuarioTelefono());	
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
	
	public List<DataReseña> MisReseñasObtenidas(String ProveedorCorreo){		
		em.getTransaction().begin();
		Proveedor prov;
		try{
			prov = (Proveedor)em.find(Proveedor.class, ProveedorCorreo);
			if(prov == null){
				return null;
			}
		}catch(Exception e){
			return null;
		}
		em.flush();
		List<DataReseña> ListaReseña = new ArrayList<DataReseña>();
		List<InstanciaServicio> ListaInstanciaServicio = prov.getInstanciasServicio();
		for(InstanciaServicio is : ListaInstanciaServicio){
			if(is.getReseñaCliente() != null){
				ListaReseña.add(is.getReseñaCliente().getDataReseña());
			}
		}
		return ListaReseña;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void RetirarFondos(String ProveedorCorreo){			
	}
	
	
	public void NotificarArribo(int InstanciaServicioId){		
	}
	
	public void AsociarMecanismoDePago(String ProveedorCorreo, String MedioDePago){		
		//Este parece no estar bien definido, hay que ver bien como se maneja el asociar paypal
	}
	
	@Override
	public void Cobrar(String ProveedorCorreo){
		//No es lo mismo que RetirarFrondos??
	}
	
	
	
	
	
		
	
	
	
}
