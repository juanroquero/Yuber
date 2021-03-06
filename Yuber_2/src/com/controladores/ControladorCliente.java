package com.controladores;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.datatypes.*;
import com.entities.Cliente;
import com.entities.InstanciaServicio;
import com.entities.Proveedor;
import com.entities.Reseña;
import com.entities.Servicio;
import com.entities.Usuario;
import com.utils.ControlErrores;
import com.webservices.ControladorClienteWS;

@Stateless
@LocalBean
@Path("/")
public class ControladorCliente implements ControladorClienteWS {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Yuber_2");
	EntityManager em = emf.createEntityManager();
	ControlErrores Error = new ControlErrores();
	
	
	public ControladorCliente() {
	}
	
	
	@Override
	public void AsociarMecanismoDePago(String ClienteCorreo, String MedioDePago){		
	//Este parece no estar bien definido, hay que ver bien como se maneja el asociar paypal
	}
	
	
	@Override
	public String CancelarPedido(int InstanciaServicioId){	
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
			//Elimino la instancia en proveedor
			if (is.getProveedor() != null){
				Proveedor Proveedor = is.getProveedor();
				List<InstanciaServicio> lista = Proveedor.getInstanciasServicio();
				lista.remove(is);
				Proveedor.setInstanciasServicio(lista);		
				//HAY QUE AVISAR AL PROVEEDOR/ VER SI SE MANDA NOTIFICACION O QUE
			}
			//elimino la InstanciaServicio
			em.remove(is);
			em.getTransaction().commit();
			return Error.Ok;
	}
		
	
	@Override
	public boolean Login(String ClienteEmail, String Password){	
		return true;
	}
	
	
	@Override
	public List<DataReseña> MisReseñasObtenidas(String ClienteCorreo){
		em.getTransaction().begin();
		Cliente cliente;
		try{
			cliente = (Cliente)em.find(Cliente.class, ClienteCorreo);
			if(cliente == null){
				return null;
			}
		}catch(Exception e){
			return null;
		}
		em.flush();
		List<DataReseña> ListaReseña = new ArrayList<DataReseña>();
		List<InstanciaServicio> ListaInstanciaServicio = cliente.getInstanciasServicio();
		for(InstanciaServicio is : ListaInstanciaServicio){
			if(is.getReseñaProveedor() != null){
				ListaReseña.add(is.getReseñaProveedor().getDataReseña());
			}
		}
		return ListaReseña;
	}
	
	
	@Override
	public List<DataCliente> ObtenerClientes(){	
		List<DataCliente> ListaDataCliente = new ArrayList<DataCliente>();
		List<Cliente> ListaCliente = em.createQuery(
				"SELECT u FROM Cliente u", Cliente.class).getResultList();
		for (Cliente Cliente : ListaCliente){ 
			DataCliente dc = Cliente.getDataCliente();
			ListaDataCliente.add(dc);
		}
		return ListaDataCliente;
	}
	
	
	@Override
	public List<DataInstanciaServicio> ObtenerHistorial(String ClienteCorreo, int ServicioId){		
		List<DataInstanciaServicio> ListaDataInstanciaServicio = new ArrayList<DataInstanciaServicio>();		
		Query query = em.createNamedQuery("ObtenerHistorialCliente", InstanciaServicio.class).
				setParameter("ClienteCorreo", ClienteCorreo).setParameter("ServicioId", ServicioId);
		List<InstanciaServicio> ListaInstanciaServicio = query.getResultList();
		for (InstanciaServicio InstanciaServicio : ListaInstanciaServicio){ 
			DataInstanciaServicio DataInstanciaServicio = InstanciaServicio.getDataInstanciaServicio();
			ListaDataInstanciaServicio.add(DataInstanciaServicio);
		}
		return ListaDataInstanciaServicio;
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
	
	
	@Override
	public int PedirServicio(String ClienteCorreo, int ServicioId, DataUbicacion DataUbicacion){
		//Busco el servicio
		em.getTransaction().begin();
		Servicio Servicio = (Servicio)em.find(Servicio.class, ServicioId);
		em.flush();
		//Busco al cliente que lo solicito
		Cliente Cliente = (Cliente)em.find(Cliente.class, ClienteCorreo);
		em.flush();
		//Creo la instancia servicio y le asocio dicho servicio
		InstanciaServicio is = new InstanciaServicio();
		is.setInstanciaServicioCosto(0);
		is.setInstanciaServicioDistancia(0);
		is.setInstanciaServicioFechaInicio(null);
		is.setInstanciaServicioFechaFin(null);
		is.setInstanciaServicioTiempo(0);
		is.setReseñaCliente(null);
		is.setReseñaProveedor(null);
		is.setProveedor(null);
		is.setCliente(Cliente);
		is.setServicio(Servicio);
		is.setLatitud(DataUbicacion.getLatitud());
		is.setLongitud(DataUbicacion.getLongitud());
		//Guardo el BD
		List<InstanciaServicio> ListaInstanciaServicio = Cliente.getInstanciasServicio();
		ListaInstanciaServicio.add(is);
		Cliente.setInstanciasServicio(ListaInstanciaServicio);
		em.persist(is);
		em.getTransaction().commit();		
		return is.getInstanciaServicioId();
	}
	
	
	@Override
	@POST
	@Path("/cliente")
	@Produces(MediaType.APPLICATION_JSON)
	public String PuntuarCliente(int Puntaje, String Comentario, int InstanciaServicioId){	
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
		InstanciaServicio.setReseñaCliente(Reseña);
		//Guardo el BD
		em.persist(InstanciaServicio);
		em.getTransaction().commit();		
		return RecalcularPromedio(InstanciaServicio.getCliente());
	}
	
	
	private String RecalcularPromedio(Cliente Cliente){
		try{
			List<InstanciaServicio> ListaInstancias = Cliente.getInstanciasServicio();
			float suma = 0;
			int cantidad = 0;
			for(InstanciaServicio is : ListaInstancias){
				suma += is.getReseñaCliente().getReseñaPuntaje();
				cantidad++;
			}			
			float promedio = suma/cantidad;
			Cliente.setUsuarioPromedioPuntaje(promedio);			
			em.getTransaction().begin();;
			em.persist(Cliente);
			em.getTransaction().commit();	
			return Error.Ok;
		}catch(Exception e){
			return Error.C53;
		}
	}
	
	
	@Override
	public void RegistrarCliente(DataCliente Cliente){	
		Cliente user = new Cliente();
		user.setUsuarioNombre(Cliente.getUsuarioNombre());
		user.setUsuarioApellido(Cliente.getUsuarioApellido());
		user.setUsuarioCiudad(Cliente.getUsuarioCiudad());
		user.setUsuarioContraseña(Cliente.getUsuarioContraseña());
		user.setUsuarioCorreo(Cliente.getUsuarioCorreo());
		user.setUsuarioDireccion(Cliente.getUsuarioDireccion());		
		user.setUsuarioPromedioPuntaje(0);
		user.setUsuarioTelefono(Cliente.getUsuarioTelefono());
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
	
	
}
