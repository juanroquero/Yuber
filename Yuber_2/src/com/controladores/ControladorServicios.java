package com.controladores;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.datatypes.*;
import com.entities.Servicio;
import com.entities.Vertical;
import com.utils.ControlErrores;
public class ControladorServicios {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Yuber_2");
	EntityManager em = emf.createEntityManager();
	ControlErrores Error = new ControlErrores();
	
	public ControladorServicios() {
	}
	
	public List<DataServicio> ObtenerServicios(String TipoDeVertical){
		List<DataServicio> ListaDataServicios = new ArrayList<DataServicio>();		
		Vertical Vertical = em.find(Vertical.class, TipoDeVertical);
		for(Servicio Servicio : Vertical.getServicios()){
			ListaDataServicios.add(Servicio.getDataServicio());
		}		
		return ListaDataServicios;		
	}
	
	public boolean CrearServicio(DataServicio Servicio){
		//Retorna false si no existe la vertical
		try{
			Vertical Vertical = em.find(Vertical.class, Servicio.getVertical().getVerticalTipo());			
			if(Vertical != null){	
				Servicio NuevoServicio = new Servicio(Servicio.getServicioId(), Servicio.getServicioNombre(), Servicio.getServicioPrecioHora(), Servicio.getServicioPrecioKM(), Servicio.getServicioTarifaBase(), null, Vertical, null);
				em.getTransaction().begin();;
				em.persist(NuevoServicio);
				em.getTransaction().commit();				
				return true;
			}
			return false;
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean EliminarServicio(int ServicioId){
		//Retorna false si no existe dicho servicio
		try{
			Servicio Servicio = this.em.find(Servicio.class, ServicioId);
			Servicio.setBorrado(1);
			this.em.getTransaction().begin();
			this.em.persist(Servicio);
			this.em.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}		
	}
	
	public boolean ModificarServicio(DataServicioBasico Servicio){
		//Retorna false si no existe dicho servicio
		try{
			Servicio NuevoServicio = this.em.find(Servicio.class, Servicio.getServicioId());
			NuevoServicio.setServicioNombre(Servicio.getServicioNombre());
			NuevoServicio.setServicioPrecioHora(Servicio.getServicioPrecioHora());
			NuevoServicio.setServicioPrecioKM(Servicio.getServicioPrecioKM());
			NuevoServicio.setServicioTarifaBase(Servicio.getServicioTarifaBase());
			em.getTransaction().begin();;
			em.persist(NuevoServicio);
			em.getTransaction().commit();				
			return true;
		}catch(Exception e){
			return false;
		}		
	}
	
	public DataServicio ObtenerServicio(int ServicioId){
		try{
			return this.em.find(Servicio.class, ServicioId).getDataServicio();
		}catch(Exception e){
			return new DataServicio();
		}	
	}
	
}
