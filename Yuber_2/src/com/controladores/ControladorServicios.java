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
import com.webservices.ControladorServiciosWS;
public class ControladorServicios implements ControladorServiciosWS {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Yuber_2");
	EntityManager em = emf.createEntityManager();
	ControlErrores Error = new ControlErrores();
	
	public ControladorServicios() {
	}
	
	@Override
	public List<DataServicio> ObtenerServicios(String TipoDeVertical){ 
		List<DataServicio> ListaDataServicios = new ArrayList<DataServicio>();		
		//Verifico que exista la vertical
		Vertical vertical; 
		try{
			vertical = em.find(Vertical.class, TipoDeVertical);
		}catch(Exception e){
			return ListaDataServicios;
		}
		if(vertical == null){
			return ListaDataServicios;
		}
		//Existe, traigo las que esta activas
		Query query = em.createNamedQuery("BuscarServiciosActivosDeVertical", Servicio.class).setParameter("TipoVertical", TipoDeVertical);
		List<Servicio> ListaServicio = query.getResultList();		
		for(Servicio Servicio : ListaServicio){
			ListaDataServicios.add(Servicio.getDataServicio());
		}		
		return ListaDataServicios;
	}
	
	@Override
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
		return Persistir(NuevoServicio);
	}
	
	@Override
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
		return Persistir(servicio);
	}
	
	@Override
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
		return Persistir(NuevoServicio);				
	}
	
	@Override
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
