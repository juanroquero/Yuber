package com.controladores;
import java.util.ArrayList;
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

import com.datatypes.*;
import com.entities.Cliente;
import com.entities.InstanciaServicio;
import com.entities.Proveedor;
import com.entities.Servicio;
import com.entities.Usuario;

public class ControladorProveedor {

	EntityManagerFactory emf;
	EntityManager em;
	
	public ControladorProveedor() {
	}
	
	public void prueba(){
	//	for (DataInstanciaServicio dti : lista){ 
		//	System.out.println(dti.getInstanciaServicioFecha());
	//	}
		

		InstanciaServicio is = new InstanciaServicio();
		is.setInstanciaServicioCosto(2);
		is.setInstanciaServicioDistancia(152);
		is.setInstanciaServicioFecha("12/25/1468");
		is.setInstanciaServicioTiempo(253);
		is.setReseñaCliente(null);
		is.setReseñaProveedor(null);
		is.setProveedor(null);
		is.setCliente(null);
		
		/*
		Usuario u = new Proveedor();	
		u.setUsuarioNombre("Martin");
		u.setUsuarioApellido("Perez");
		u.setUsuarioCiudad("San Jose");
		u.setUsuarioContraseña("user1");
		u.setUsuarioCorreo("user1@hotmail.com");
		u.setUsuarioDireccion("18 de julio 321");		
		u.setUsuarioPromedioPuntaje(3);
		u.setUsuarioTelefono(4);
		*/
		/*
	    Servicio s = new Servicio();
		s.setInstanciasServicio(null);
		s.setProveedores(null);
		s.setServicioNombre("Taxi");
		s.setServicioPrecioHora(400);
		s.setServicioPrecioKM(30);
		s.setServicioTarifaBase(50);
		s.setVertical(null);
		*/
		
		emf = Persistence.createEntityManagerFactory("Yuber_2");
		em = emf.createEntityManager();	
		em.getTransaction().begin();
		em.persist(is);
		em.getTransaction().commit();
		
		
	}
	
	public void PuntuarProveedor(String ProveedorCorreo, int Puntaje){		
	}
	
	public void RegistrarProveedor(DataProveedor Cliente){		
	}
	
	public void Login(String ProveedorEmail, String Password){		
	}
	
	public void AceptarServicio(int InstanciaServicioId){		
	}
	
	public void RechazarServicio(int InstanciaServicioId){		
	}
	
	public void IniciarJornada(String ProveedorCorreo, int ServicioId){		
	}
	
	public void FinalizarJornada(String ProveedorCorreo, int ServicioId){		
	}
	
	public List<DataReseña> ReseñaServicios(String ProveedorCorreo){
		return null;
	}
	
	public void RetirarFondos(String ProveedorCorreo){	
		
	}
	
	public List<DataInstanciaServicio> ObtenerHistorial(String ProveedorCorreo){		
		List<DataInstanciaServicio> ListaDataInstanciaServicio = new ArrayList<DataInstanciaServicio>();
		//NO SE HACE LA QUERY
		//NO SE HACE LA QUERY
		//NO SE HACE LA QUERY
		//NO SE HACE LA QUERY
		List<InstanciaServicio> ListaInstanciaServicio = em.createQuery(
				"select is from InstanciaServicio is", InstanciaServicio.class).getResultList();
		for (InstanciaServicio InstanciaServicio : ListaInstanciaServicio){ 
			DataInstanciaServicio DataInstanciaServicio = InstanciaServicio.getDataInstanciaServicio();
			ListaDataInstanciaServicio.add(DataInstanciaServicio);
		}
		return ListaDataInstanciaServicio;
	}
	
	public void NotificarArribo(int InstanciaServicioId){
		
	}
	
	public void IniciarServicio(int InstanciaServicioId, String Correo){		
		//Busco la InstanciaServicio 
		emf = Persistence.createEntityManagerFactory("Yuber_2");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		InstanciaServicio is = (InstanciaServicio)em.find(InstanciaServicio.class, InstanciaServicioId);
		em.flush();
		//Busco al Proveedor
		Proveedor prov = (Proveedor)em.find(Proveedor.class, Correo);
		em.flush();
		//Asocio al provedor dicha InstanciaServicio
		prov.addInstanciaServicio(is);
		em.getTransaction().commit();
		em.close();		
	}
	
	public void FinServicio(int InstanciaServicioId, float InstanciaServicioCosto, float InstanciaServicioDistancia, float InstanciaServicioTiempo){	
		//Busco la InstanciaServicio 
		emf = Persistence.createEntityManagerFactory("Yuber_2");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		InstanciaServicio is = (InstanciaServicio)em.find(InstanciaServicio.class, InstanciaServicioId);
		em.flush();
		//Actualizo los campos
		is.setInstanciaServicioCosto(InstanciaServicioCosto);
		is.setInstanciaServicioDistancia(InstanciaServicioDistancia);
		is.setInstanciaServicioTiempo(InstanciaServicioTiempo);
		em.getTransaction().commit();
		em.close();
	}
	
	public boolean OlvidePass(String ClienteCorreo){	
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
			emf = Persistence.createEntityManagerFactory("Yuber_2");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Proveedor prov = (Proveedor)em.find(Proveedor.class, ClienteCorreo);
			em.flush();
			prov.setUsuarioContraseña(String.valueOf(pass));			
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (MessagingException e) {
			return false;
		}
	}
	
	public void AsociarMecanismoDePago(String ProveedorCorreo, String MedioDePago){		
	//Este parece no estar bien definido, hay que ver bien como se maneja el asociar paypal
	}
	
	public void Cobrar(String ProveedorCorreo){
		//No es lo mismo que RetirarFrondos??
	}
}
