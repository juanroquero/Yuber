package com.controladores;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.datatypes.*;
public class ControladorServicios {

	EntityManagerFactory emf;
	EntityManager em;
	
	public ControladorServicios() {
	}
	
	public List<DataServicio> ObtenerServicios(String TipoDeVertical){
		return null;
	}
	
	public void CrearServicio(DataServicio Servicio){
	}
	
	public void EliminarServicio(int ServicioId){
	}
	
	public void ModificarServicio(DataServicio Servicio){
	}
	
	public DataServicio ObtenerServicio(int ServicioId){
		return null;
	}
}
