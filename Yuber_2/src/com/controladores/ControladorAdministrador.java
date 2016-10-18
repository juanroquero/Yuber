package com.controladores;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
	
	public boolean CrearAdministrador(DataAdministrador Administrador){
		try{				
			List<DataVerticalBasico> ListaDataVerticales = Administrador.getVerticales();
			List <Vertical> ListaVerticales = new ArrayList<Vertical>();
			Administrador Admin = new Administrador(Administrador.getAdministradorCorreo(), Administrador.getAdministradorContraseña(), Administrador.getAdministradorNombre(), null);
			em.getTransaction().begin();;
			em.persist(Admin);
			em.getTransaction().commit();	
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public void EliminarAdministrador(String AdministradorEmail){
		em.createQuery("SELECT p FROM Proveedor p", Proveedor.class);
		 int deletedVerticalseDeAdmin = em.createQuery("DELETE FROM Country").executeUpdate();
		
		Administrador Admin = this.em.find(Administrador.class, AdministradorEmail);
		this.em.getTransaction().begin();
		this.em.remove(Admin);
		this.em.getTransaction().commit();
	}
	
	public boolean ModificarAdministrador(DataAdministrador Administrador){
		Administrador Admin = this.em.find(Administrador.class, Administrador.getAdministradorCorreo());
		if(Admin != null){
			List<DataVerticalBasico> ListaDataVerticales = Administrador.getVerticales();					
			if(ListaDataVerticales != null){
				List <Vertical> ListaVerticales = new ArrayList<Vertical>();
				for(DataVerticalBasico DataVertical : ListaDataVerticales){
					Vertical Vertical = this.em.find(Vertical.class, DataVertical.getVerticalTipo());
					if (Vertical != null){
						ListaVerticales.add(Vertical);							
						List<Administrador> la = Vertical.getAdministradores();						
						boolean esta = false;
						for( Administrador administrador : la){
							if(administrador.getAdministradorCorreo().equals(Admin.getAdministradorCorreo())){
								esta = true;
							}						
						}					
						if(! esta){
							la.add(Admin);						
							Vertical.setAdministradores(la);
						}
					}	
				}	
				Admin.setVerticales(ListaVerticales);				
			}	
			Admin.setAdministradorContraseña(Administrador.getAdministradorContraseña());
			Admin.setAdministradorNombre(Administrador.getAdministradorNombre());		
			em.getTransaction().begin();;
			em.persist(Admin);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public DataAdministrador ObtenerAdministrador(String AdministradorEmail){
		try{
			return this.em.find(Administrador.class, AdministradorEmail).getDataAdministrador();
		}catch(Exception e){
			return new DataAdministrador();
		}	
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
	
	public void CrearVertical(DataVertical Vertical){
		Vertical NuevaVertical = new Vertical(Vertical.getVerticalTipo(), Vertical.getVerticalNombre(), null, null);
		em.getTransaction().begin();;
		em.persist(NuevaVertical);
		em.getTransaction().commit();
	}
	
	public String AsignarVertical(String AdminCreadorId, String AdminId, String TipoVertical){
		boolean Habilitado = false;
		if(AdminCreadorId == "FullAccess")
		{
			Habilitado = true;
		}
		else
		{
			DataAdministrador AdminCreador = this.em.find(Administrador.class, AdminCreadorId).getDataAdministrador();
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
			Administrador Admin = this.em.find(Administrador.class, AdminId);
			Vertical Vertical = this.em.find(Vertical.class, TipoVertical);
			
			List<Administrador> ListaAdmin = Vertical.getAdministradores();
			ListaAdmin.add(Admin);
			Vertical.setAdministradores(ListaAdmin);
			
			List<Vertical> ListaVerticales = Admin.getVerticales();
			ListaVerticales.add(Vertical);
			Admin.setVerticales(ListaVerticales);
			
			em.getTransaction().begin();
			em.persist(Admin);
			em.getTransaction().commit();
			
			return Error.Ok;
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
			DataAdministrador AdminCreador = this.em.find(Administrador.class, AdminCreadorId).getDataAdministrador();
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
			Administrador Admin = this.em.find(Administrador.class, AdminId);
			Vertical Vertical = this.em.find(Vertical.class, TipoVertical);
			
			List<Administrador> ListaAdmin = Vertical.getAdministradores();
			ListaAdmin.remove(Admin);
			Vertical.setAdministradores(ListaAdmin);
			
			List<Vertical> ListaVerticales = Admin.getVerticales();
			ListaVerticales.remove(Vertical);
			Admin.setVerticales(ListaVerticales);
			
			em.getTransaction().begin();
			em.persist(Admin);
			em.getTransaction().commit();
			
			return Error.Ok;
		}
		else
		{
			return Error.A51;
		}
	}
	
	
}
