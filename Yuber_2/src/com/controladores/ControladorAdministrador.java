package com.controladores;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.datatypes.*;
import com.entities.Administrador;
import com.entities.Cliente;
import com.entities.InstanciaServicio;
import com.entities.Proveedor;
import com.entities.Usuario;
import com.entities.Vertical;

import java.util.ArrayList;
import java.util.List;

public class ControladorAdministrador {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Yuber_2");
	EntityManager em = emf.createEntityManager();
	
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
		List<DataVertical> ListaDataVerticales = Administrador.getVerticales();
		List <Vertical> ListaVerticales = new ArrayList<Vertical>();
		
		if(ListaDataVerticales != null)
		{
			for(DataVertical DataVertical : ListaDataVerticales)
			{
				Vertical Vertical = this.em.find(Vertical.class, DataVertical.getVerticalTipo());
				if (Vertical != null)
				{
					ListaVerticales.add(Vertical);
				}		
				else
				{
					return false;
				}
			}	
		}			
		Administrador Admin = new Administrador(Administrador.getAdministradorCorreo(), Administrador.getAdministradorContraseña(), Administrador.getAdministradorNombre(), ListaVerticales);
		em.getTransaction().begin();;
		em.persist(Admin);
		em.getTransaction().commit();		
		
		return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public void EliminarAdministrador(String AdministradorEmail){
		try{
			Administrador Admin = this.em.find(Administrador.class, AdministradorEmail);
			this.em.getTransaction().begin();
			this.em.remove(Admin);
			this.em.getTransaction().commit();
		}catch(Exception e){
		}	
	}
	
	public void ModificarAdministrador(DataAdministrador Administrador){
		Administrador Admin = this.em.find(Administrador.class, Administrador.getAdministradorCorreo());
		
		List<DataVertical> ListaDataVerticales = Administrador.getVerticales();
		List <Vertical> ListaVerticales = new ArrayList<Vertical>();
		
		if(ListaDataVerticales != null)
		{
			for(DataVertical DataVertical : ListaDataVerticales)
			{
				Vertical Vertical = this.em.find(Vertical.class, DataVertical.getVerticalTipo());
				if (Vertical != null)
					ListaVerticales.add(Vertical);
				
			}	
			Admin.setVerticales(ListaVerticales);
		}	
		Admin.setAdministradorContraseña(Administrador.getAdministradorContraseña());
		Admin.setAdministradorNombre(Administrador.getAdministradorNombre());		
		em.getTransaction().begin();;
		em.persist(Admin);
		em.getTransaction().commit();
		
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
	
	public void CrearVertical(String tipo){
	}
	
}
