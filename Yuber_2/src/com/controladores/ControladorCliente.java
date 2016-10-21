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
		}
		catch(Exception e){
			return Error.C53;
		}
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
		//Busco al cliente
		Cliente Cliente;
		try{
			Cliente = (Cliente)em.find(Cliente.class, ClienteCorreo);
			em.flush();
			if(Cliente == null){
				return null;
			}
		}catch(Exception e){
			return null;
		}					
		List<DataInstanciaServicio> ListaDataInstanciaServicio = new ArrayList<DataInstanciaServicio>();
		for(InstanciaServicio is : Cliente.getInstanciasServicio()){
			if (is.getServicio().getServicioId() == ServicioId){
				ListaDataInstanciaServicio.add(is.getDataInstanciaServicio());
			}
		}	
		return ListaDataInstanciaServicio;
	}
	
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
	
	public boolean Login(String ClienteEmail, String Password){	
		return true;
	}
	
}
