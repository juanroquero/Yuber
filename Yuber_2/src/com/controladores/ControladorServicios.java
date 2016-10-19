package com.controladores;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.datatypes.*;
import com.entities.Proveedor;
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
		/*
		List<DataServicio> ListaDataServicios = new ArrayList<DataServicio>();		
		Vertical vertical; 
		try{
			vertical = em.find(Vertical.class, TipoDeVertical);
		}catch(Exception e){
			return null;
		}
		if(vertical == null){
			return null;
		}
		for(Servicio Servicio : vertical.getServicios()){
			ListaDataServicios.add(Servicio.getDataServicio());
		}
		return ListaDataServicios;
		*/
		List<DataServicio> ListaDataServicios = new ArrayList<DataServicio>();
		Vertical vertical;
		
		em.getTransaction().begin();
		Query query = em.createNamedQuery("BuscarServiciosActivos", Servicio.class).setParameter("val", 0);
		List<Servicio> list = query.getResultList();
		
	/*	List<Proveedor> ListaProveedores = em.createQuery(
		"Select s from Servicio AS s where s.BORRADO = 0", Proveedor.class).getResultList();
		*/
		return null;
		
		
		
	}
	
	public String CrearServicio(DataServicioBasico Servicio, String TipoVertical){
		Vertical vertical;
		try{
			vertical = em.find(Vertical.class, TipoVertical);
		}catch(Exception e){
			return Error.S1;
		}
		if(vertical == null){
			return Error.S1;
		}
		Servicio NuevoServicio = new Servicio(Servicio.getServicioId(), Servicio.getServicioNombre(), Servicio.getServicioPrecioHora(), Servicio.getServicioPrecioKM(), Servicio.getServicioTarifaBase(), null, vertical, null);
		try {
			em.getTransaction().begin();
			em.persist(NuevoServicio);
			em.getTransaction().commit();
		} catch (Exception e) {
		    em.getTransaction().rollback();
		    return Error.G1;
		}	
		return Error.Ok;
	}
	
	public String EliminarServicio(int ServicioId){
		Servicio servicio;
		try{
			servicio = this.em.find(Servicio.class, ServicioId);
		}catch(Exception e){
			return Error.S2;
		}	
		if(servicio == null){
			return Error.S2;
		}
		servicio.setBorrado(1);
		try {
			this.em.getTransaction().begin();
			this.em.persist(servicio);
			this.em.getTransaction().commit();
		} catch (Exception e) {
		    em.getTransaction().rollback();
		    return Error.G1;
		}	
		return Error.Ok;			
	}
	
	public String ModificarServicio(DataServicioBasico Servicio){
		Servicio NuevoServicio;
		try{
			NuevoServicio = this.em.find(Servicio.class, Servicio.getServicioId());
		}catch(Exception e){
			return Error.S2;
		}
		if(NuevoServicio == null){
			return Error.S2;
		}
		NuevoServicio.setServicioNombre(Servicio.getServicioNombre());
		NuevoServicio.setServicioPrecioHora(Servicio.getServicioPrecioHora());
		NuevoServicio.setServicioPrecioKM(Servicio.getServicioPrecioKM());
		NuevoServicio.setServicioTarifaBase(Servicio.getServicioTarifaBase());
		try {
			em.getTransaction().begin();;
			em.persist(NuevoServicio);
			em.getTransaction().commit();
		} catch (Exception e) {
		    em.getTransaction().rollback();
		    return Error.G1;
		}
		return Error.Ok;				
	}
	
	public DataServicio ObtenerServicio(int ServicioId){
		DataServicio ds;
		try{
			ds = this.em.find(Servicio.class, ServicioId).getDataServicio();
		}catch(Exception e){	
			ds = new DataServicio();
			ds.setEstado(Error.S2);
			return ds;
		}	
		if (ds == null){
			ds = new DataServicio();
			ds.setEstado(Error.S2);
			return ds;
		}
		ds.setEstado(Error.Ok);
		return ds;		
	}
	
}
