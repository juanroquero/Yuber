package com.controladores;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entities.Servicio;
import com.entities.Sesion;
import com.entities.Vertical;
import com.utils.ControlErrores;

public class ControladorSesion {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Yuber_2");
	EntityManager em = emf.createEntityManager();
	ControlErrores Error = new ControlErrores();
	
	public ControladorSesion() {
	}
	
	public int CrearSesion(String CorreoUsuario, String SesionDeviceID){
		java.util.Date Fecha = new Date();		
		Sesion sesion = new Sesion();
		sesion.setCorreoUsuario(CorreoUsuario);
		sesion.setFecha(Fecha);
		sesion.setSesionDeviceID(SesionDeviceID);
		sesion.setSesionHabilitada(true);
		Persistir(sesion);		
		return sesion.getSesionId();
	}
	
	public String DeshabilitarSesion(String sesionId){
		Sesion sesion;
		try{
			sesion = this.em.find(Sesion.class, sesionId);
		}catch(Exception e){
			return Error.L1;
		}
		if(sesion == null){
			return Error.L1;
		}
		sesion.setSesionHabilitada(false);				
		return Persistir(sesion);				
	}
	
	public boolean EstaLogeado(String correo){
		boolean logueado = false;
		Query query = em.createNamedQuery("EstaLogeado", Sesion.class).setParameter("CorreoUsuario", correo);
		List<Sesion> ListaSesion = query.getResultList();		
		for(Sesion sesion : ListaSesion){
			if(sesion.getSesionHabilitada() == true){
				logueado = true;
			}
		}		
		return logueado;
	}
	
	public String HabilitarSesion(String sesionId){
		Sesion sesion;
		try{
			sesion = this.em.find(Sesion.class, sesionId);
		}catch(Exception e){
			return Error.L1;
		}
		if(sesion == null){
			return Error.L1;
		}
		sesion.setSesionHabilitada(true);				
		return Persistir(sesion);
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
