package com.controladores;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.datatypes.*;
import com.entities.Administrador;
import com.entities.Cliente;
import com.entities.InstanciaServicio;
import com.entities.Proveedor;
import com.entities.Vertical;
import com.utils.ControlErrores;
import com.webservices.ControladorAdministradorWS;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ControladorAdministrador implements ControladorAdministradorWS {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Yuber_2");
	EntityManager em = emf.createEntityManager();
	ControlErrores Error = new ControlErrores();
	
	public ControladorAdministrador() {
	}

	@Override
	public void Login(String AdministradorEmail, String Password){					
	}
	
	@Override
	public List<DataClienteBasico> ObtenerClientesActivos(){
		//Se considera clientes activos aquellos que tienen
		//instancia_servicio con menos de 30 dias 
	/*	Date fechaHoy = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaHoy); 
		calendar.add(Calendar.MONTH, -1);  
		Date fecha = calendar.getTime();
		 
		List<DataClienteBasico> ListaDataClientes = new ArrayList<DataClienteBasico>();
		Query query = em.createNamedQuery("ObtenerClientesActivos", Cliente.class);
		query.setParameter("Fecha", fecha);
		List<Cliente> ListaCliente = query.getResultList();		
		for(Cliente Cliente : ListaCliente){
			ListaDataClientes.add(Cliente.getDataClienteBasico());
		}		*/
		return null;
	}
	
	@Override
	public List<DataProveedorBasico> ObtenerProveedoresActivos(){
		//Se considera provedores activos aquellos que tienen
		//instancia_servicio con menos de 30 dias
		/*Date fechaHoy = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaHoy); 
		calendar.add(Calendar.MONTH, -1);  
		Date fecha = calendar.getTime();
		  
		List<DataProveedorBasico> ListaDataProveedores = new ArrayList<DataProveedorBasico>();
		Query query = em.createNamedQuery("ObtenerProveedoresActivos", Proveedor.class);
		query.setParameter("Fecha", fecha);
		List<Proveedor> ListaProveedor = query.getResultList();		
		for(Proveedor Proveedor : ListaProveedor){
			ListaDataProveedores.add(Proveedor.getDataProveedorBasico());
		}		*/
		return null;		
	}
	
	@Override
	public String CrearAdministrador(DataAdministradorBasico Administrador){
		try{			
			Administrador Admin = new Administrador(Administrador.getAdministradorCorreo(), Administrador.getAdministradorContraseña(), Administrador.getAdministradorNombre(), null);
			return Persistir(Admin);
		}catch(Exception e){
			return Error.A53 + " : "+ Administrador.getAdministradorCorreo();
		}
	}
	
	@Override
	public String EliminarAdministrador(String AdministradorEmail){
		try{
			Administrador Admin = this.em.find(Administrador.class, AdministradorEmail);
			for(Vertical Vert : Admin.getVerticales())
			{				
				String Result = this.DenegarVertical("FullAccess", AdministradorEmail, Vert.getVerticalTipo());
				if(Result != Error.Ok)
					return Result;
			}			
			return Persistir(Admin);
		}catch(Exception e){
			return Error.A52;
		}	
	}
	
	@Override
	public String ModificarAdministrador(DataAdministradorBasico Administrador){
		Administrador Admin;
		try{			
				Admin = this.em.find(Administrador.class, Administrador.getAdministradorCorreo());
		}catch(Exception e){
			return Error.A52;
		}
		if (Admin != null)
		{
			Admin.setAdministradorContraseña(Administrador.getAdministradorContraseña());
			Admin.setAdministradorNombre(Administrador.getAdministradorNombre());		
			return Persistir(Admin);
		}
		else
		{
			return Error.A52;
		}
		
	}
	
	@Override
	public DataAdministrador ObtenerAdministrador(String AdministradorEmail){	
			DataAdministrador DAdmin;
			try{
				DAdmin = this.em.find(Administrador.class, AdministradorEmail).getDataAdministrador();
				if(DAdmin == null)
					DAdmin = new DataAdministrador();
					DAdmin.setEstado(Error.A52);
			}catch(Exception e){
				DAdmin = new DataAdministrador();
				DAdmin.setEstado(Error.A52);
			}
			return DAdmin;
	}	
	
	@Override
	public float ObtenerGananciaMensual(Date fecha){		  
		//obtengo el primer dia del mes
		Date fechaInicio = fecha;
		fechaInicio.setDate(1);
		//Calulo el ultimo dia del mes		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaInicio); 
		calendar.add(Calendar.MONTH, + 1);  
		calendar.add(Calendar.DATE, - 1);  
		Date fechaFin = calendar.getTime();
		//Hago la consulta		
		Query query = em.createNamedQuery("ObtenerGananciaMensual", InstanciaServicio.class);
		query.setParameter("FechaInicio", fechaInicio);
		query.setParameter("FechaFin", fechaFin);		
		List<InstanciaServicio> ListaInstanciaServicio = query.getResultList();
		float ganancia = 0;
		for(InstanciaServicio is : ListaInstanciaServicio){
			ganancia += is.getInstanciaServicioCosto();
		}		
		return ganancia;
	}
	
	@Override
	public List<DataProveedorBasico> TopProveedoresPorPuntajes(int Limit){
		List<DataProveedorBasico> ListaDataProveedores = new ArrayList<DataProveedorBasico>();
		Query query = em.createNamedQuery("TopProveedoresPorPuntajes", Proveedor.class);
		query.setMaxResults(Limit);	
		List<Proveedor> ListaProveedor = query.getResultList();
		for(Proveedor prov : ListaProveedor){
			ListaDataProveedores.add(prov.getDataProveedorBasico());
		}		
		return ListaDataProveedores;
	}
	
	@Override
	public List<DataProveedorBasico> TopProveedoresPorGanancia(int Limit){
	/*	List<DataProveedorBasico> ListaDataProveedores = new ArrayList<DataProveedorBasico>();
		Query query = em.createNamedQuery("TopProveedoresPorGanancia", Proveedor.class);
		query.setMaxResults(Limit);	
		List<Proveedor> ListaProveedor = query.getResultList();
		for(Proveedor prov : ListaProveedor){
			ListaDataProveedores.add(prov.getDataProveedorBasico());
		}		*/
		return null;
	}
	
	
	
	public List<DataClienteBasico> TopClientesPorCantServicios(int Limit){
	/*	List<DataClienteBasico> ListaDataClientes = new ArrayList<DataClienteBasico>();
		Query query = em.createNamedQuery("TopClientesPorCantServicios", InstanciaServicio.class);
		query.setMaxResults(Limit);	
		List<InstanciaServicio> ListaCliente = query.getResultList();
		for(InstanciaServicio user : ListaCliente){
			
			
			
			
		}		*/
		return null;
	}

	@Override
	public List<DataClienteBasico> TopClientesPorPuntaje(int Limit){
		List<DataClienteBasico> ListaDataClientes = new ArrayList<DataClienteBasico>();
		Query query = em.createNamedQuery("TopClientesPorPuntaje", Proveedor.class);
		query.setMaxResults(Limit);	
		List<Cliente> ListaClientes = query.getResultList();
		for(Cliente user : ListaClientes){
			ListaDataClientes.add(user.getDataClienteBasico());
		}		
		return ListaDataClientes;		
	}	
	
	@Override
	public String CrearVertical(DataVerticalBasico Vertical){
		try{
			Vertical NuevaVertical = new Vertical(Vertical.getVerticalTipo(), Vertical.getVerticalNombre(), null, null);	
			return Persistir(NuevaVertical);
		}catch(Exception e){
			return Error.V50 + " : "+ Vertical.getVerticalTipo();
		}
	}
	
	@Override
	public String AsignarVertical(String AdminCreadorId, String AdminId, String TipoVertical){
		boolean Habilitado = false;
		if(AdminCreadorId == "FullAccess")
		{
			Habilitado = true;
		}
		else
		{
			DataAdministrador AdminCreador;
			try{
				AdminCreador = this.em.find(Administrador.class, AdminCreadorId).getDataAdministrador();
				if(AdminCreador == null)
					return Error.A52;
			}catch(Exception e){
				return Error.A52;
			}
			for (DataVerticalBasico DataVertical : AdminCreador.getVerticales())
			{
				if (DataVertical.getVerticalTipo() == TipoVertical)
				{
					Habilitado = true;
				}
			}
		}
		if (Habilitado)
		{
			Administrador Admin;
			try{
				 Admin = this.em.find(Administrador.class, AdminId);
				if(Admin == null)
					return Error.A52;
			}catch(Exception e){
				return Error.A52;
			}
			
			Vertical Vertical;
			try{
				Vertical = this.em.find(Vertical.class, TipoVertical);
				if(Vertical == null)
					return Error.V51;
			}catch(Exception e){
				return Error.V51;
			}
			
			List<Administrador> ListaAdmin = Vertical.getAdministradores();
			ListaAdmin.add(Admin);
			Vertical.setAdministradores(ListaAdmin);
			
			List<Vertical> ListaVerticales = Admin.getVerticales();
			ListaVerticales.add(Vertical);
			Admin.setVerticales(ListaVerticales);
			
			return Persistir(Admin);
		}
		else
		{
			return Error.A50;
		}
		
				
	}
	
	@Override
	public String DenegarVertical(String AdminCreadorId, String AdminId, String TipoVertical){
		boolean Habilitado = false;
		if(AdminCreadorId == "FullAccess")
		{
			Habilitado = true;
		}
		else
		{
			DataAdministrador AdminCreador;
			try{
				AdminCreador = this.em.find(Administrador.class, AdminCreadorId).getDataAdministrador();
				if(AdminCreador == null)
					return Error.A52;
			}catch(Exception e){
				return Error.A52;
			}		
			for (DataVerticalBasico DataVertical : AdminCreador.getVerticales())
			{
				if (DataVertical.getVerticalTipo() == TipoVertical)
				{
					Habilitado = true;
				}
			}
		}
		if (Habilitado)
		{
			Administrador Admin;
			try{
				 Admin = this.em.find(Administrador.class, AdminId);
				if(Admin == null)
					return Error.A52;
			}catch(Exception e){
				return Error.A52;
			}
			
			Vertical Vertical;
			try{
				Vertical = this.em.find(Vertical.class, TipoVertical);
				if(Vertical == null)
					return Error.V51;
			}catch(Exception e){
				return Error.V51;
			}
			
			List<Administrador> ListaAdmin = Vertical.getAdministradores();
			if(ListaAdmin.remove(Admin))			
				Vertical.setAdministradores(ListaAdmin);
			else
				return Error.A54;
			
			List<Vertical> ListaVerticales = Admin.getVerticales();
			if(ListaVerticales.remove(Vertical))
				Admin.setVerticales(ListaVerticales);
			else
				return Error.V52;
			
			return Persistir(Admin);
		}
		else
		{
			return Error.A51;
		}
	}
	
	private String Persistir(Object Objeto)
	{
		try{
			em.getTransaction().begin();
			em.persist(Objeto);
			em.getTransaction().commit();
			return Error.Ok;
		}catch(Exception e){
			em.getTransaction().rollback();
			return Error.G1;
		}
	}
}
