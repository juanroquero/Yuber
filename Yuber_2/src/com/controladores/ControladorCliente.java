package com.controladores;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class ControladorCliente {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Yuber_2");
	EntityManager em = emf.createEntityManager();
	ControlErrores Error = new ControlErrores();
	
	public ControladorCliente() {
	}
	
	public void PuntuarCliente(int Puntaje, String Comentario, String InstanciaServicioId){	
		em.getTransaction().begin();		
		InstanciaServicio InstanciaServicio = (InstanciaServicio)em.find(InstanciaServicio.class, InstanciaServicioId);
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
		em.close();
	}
	
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
	
	public List<DataInstanciaServicio> ObtenerHistorial(String ClienteCorreo, int ServicioId){		
		List<DataInstanciaServicio> ListaDataInstanciaServicio = new ArrayList<DataInstanciaServicio>();
		List<InstanciaServicio> ListaInstanciaServicio = em.createQuery(
				"SELECT is FROM InstanciaServicio is WHERE is.CLIENTE_USUARIOCORREO = "+ClienteCorreo, InstanciaServicio.class).getResultList();
		for (InstanciaServicio InstanciaServicio : ListaInstanciaServicio){ 
			DataInstanciaServicio DataInstanciaServicio = InstanciaServicio.getDataInstanciaServicio();
			ListaDataInstanciaServicio.add(DataInstanciaServicio);
		}
		return ListaDataInstanciaServicio;
	}
	
	public List<DataReseña> ReseñaServicios(String ClienteCorreo){
		return null;
	}
	
	public void CancelarPedido(String InstanciaServicioId){	
			//Busco la InstanciaServicio 
			em.getTransaction().begin();
			InstanciaServicio is = (InstanciaServicio)em.find(InstanciaServicio.class, InstanciaServicioId);
			em.flush();
			//Elimino la instancia en proveedor
			if (is.getProveedor() != null){
				Proveedor Proveedor = is.getProveedor();
				List<InstanciaServicio> lista = Proveedor.getInstanciasServicio();
				lista.remove(is);
				Proveedor.setInstanciasServicio(lista);				
			}			
			//elimino la InstanciaServicio
			em.remove(is);
			em.getTransaction().commit();
			em.close();	
	}
		
	public void OlvidePass(String CienteCorreo){		
	}
	
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
		em.close(); 
	}
	
	public void AsociarMecanismoDePago(String ClienteCorreo, String MedioDePago){		
	//Este parece no estar bien definido, hay que ver bien como se maneja el asociar paypal
	}
	
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
		//Guardo el BD
		em.persist(is);
		em.getTransaction().commit();
		em.close();
		return 0;
	}
	
	public boolean Login(String ClienteEmail, String Password){	
		return true;
	}
}
