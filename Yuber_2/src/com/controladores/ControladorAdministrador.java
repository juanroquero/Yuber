package com.controladores;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.datatypes.*;
import com.entities.Administrador;
import com.entities.Cliente;
import com.entities.Proveedor;
import com.entities.Vertical;
import com.utils.ControlErrores;

import java.util.ArrayList;
import java.util.List;

public class ControladorAdministrador {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Yuber_2");
	EntityManager em = emf.createEntityManager();
	ControlErrores Error = new ControlErrores();
	
	public ControladorAdministrador() {
	}

	public void Login(String AdministradorEmail, String Password){					
	}
	
	public List<DataCliente> ObtenerClientesActivos(){
		
		List<DataCliente> ListaDataClientes = new ArrayList<DataCliente>();
		List<Cliente> ListaClientes = em.createQuery(
		"SELECT c FROM Cliente c", Cliente.class).getResultList();
		for (Cliente Cliente : ListaClientes){ 
			DataCliente DataCliente = Cliente.getDataCliente();
			ListaDataClientes.add(DataCliente);
		}
		return ListaDataClientes;
	}
	
	public List<DataProveedor> ObtenerProveedoresActivos(){
		List<DataProveedor> ListaDataProveedors = new ArrayList<DataProveedor>();
		List<Proveedor> ListaProveedores = em.createQuery(
		"SELECT p FROM Proveedor p", Proveedor.class).getResultList();
		for (Proveedor Proveedor : ListaProveedores){ 
			DataProveedor DataProveedor = Proveedor.getDataProveedor();
			ListaDataProveedors.add(DataProveedor);
		}
		return ListaDataProveedors;
	}
	
	public String CrearAdministrador(DataAdministradorBasico Administrador){
		try{			
			Administrador Admin = new Administrador(Administrador.getAdministradorCorreo(), Administrador.getAdministradorContraseña(), Administrador.getAdministradorNombre(), null);
			return Persistir(Admin);
		}catch(Exception e){
			return Error.A53 + " : "+ Administrador.getAdministradorCorreo();
		}
	}
	
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
	
	public float ObtenerGananciaMensual(){
		return 0;
	}
	
	public List<DataProveedor> TopProveedoresPorPuntajes(){
		return null;
	}
	
	public List<DataProveedor> TopProveedoresPorGanancia(){
		return null;
	}
	
	public List<DataCliente> TopClientesPorCantServicios(){
		return null;
	}
	
	public List<DataCliente> TopClientesPorPuntaje(){
		return null;		
	}	
	
	public String CrearVertical(DataVerticalBasico Vertical){
		try{
			Vertical NuevaVertical = new Vertical(Vertical.getVerticalTipo(), Vertical.getVerticalNombre(), null, null);	
			return Persistir(NuevaVertical);
		}catch(Exception e){
			return Error.V50 + " : "+ Vertical.getVerticalTipo();
		}
	}
	
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
			return Error.G1;
		}
	}
}
