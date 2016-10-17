package com.controladores;
import javax.persistence.EntityManager;

import com.datatypes.*;

import java.util.List;

public class ControladorAdministrador {

	EntityManager em;
	
	public ControladorAdministrador() {
	}

	public void Login(String AdministradorEmail, String Password){		
	}
	
	public List<DataCliente> ObtenerClientesActivos(){	
		return null;
	}
	
	public List<DataProveedor> ObtenerProveedoresActivos(){	
		return null;
	}
	
	public void CrearAdministrador(DataAdministrador Administrador){
	}
	
	public void EliminarAdministrador(int AdministradorEmail){
	}
	
	public void ModificarAdministrador(DataAdministrador Administrador){
	}
	
	public DataAdministrador ObtenerAdministrador(int AdministradorEmail){
		return null;
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
}
