package com.controladores;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import com.datatypes.*;
import com.entities.InstanciaServicio;

public class ControladorProveedor {

	EntityManager em;
	
	public ControladorProveedor() {
	}
	
	public void PuntuarProveedor(String ProveedorCorreo, int Puntaje){		
	}
	
	public void RegistrarProveedor(DataProveedor Cliente){		
	}
	
	public void Login(String ProveedorEmail, String Password){		
	}
	
	public void AceptarServicio(int InstanciaServicioId){		
	}
	
	public void RechazarServicio(int InstanciaServicioId){		
	}
	
	public void IniciarJornada(String ProveedorCorreo, int ServicioId){		
	}
	
	public void FinalizarJornada(String ProveedorCorreo, int ServicioId){		
	}
	
	public List<DataReseña> ReseñaServicios(String ProveedorCorreo){
		return null;
	}
	
	public void RetirarFondos(String ProveedorCorreo){		
	}
	
	public List<DataInstanciaServicio> ObtenerHistorial(String ProveedorCorreo){		
		List<DataInstanciaServicio> ListaDataInstanciaServicio = new ArrayList<DataInstanciaServicio>();		
		List<InstanciaServicio> ListaInstanciaServicio = em.createQuery(
				"SELECT is FROM InstanciaServicio is", InstanciaServicio.class).getResultList();
		for (InstanciaServicio InstanciaServicio : ListaInstanciaServicio){ 
			DataInstanciaServicio DataInstanciaServicio = InstanciaServicio.getDataInstanciaServicio();
			ListaDataInstanciaServicio.add(DataInstanciaServicio);
		}
		return ListaDataInstanciaServicio;
	}
	
	public void NotificarArribo(int InstanciaServicioId){		
	}
	
	public void IniciarServicio(int InstanciaServicioId){		
	}
	
	public void FinServicio(int InstanciaServicioId){		
	}
	
	public void OlvidePass(String CienteCorreo){		
	}
	
	public void AsociarMecanismoDePago(String ProveedorCorreo, String MedioDePago){		
	//Este parece no estar bien definido, hay que ver bien como se maneja el asociar paypal
	}
	
	public void Cobrar(String ProveedorCorreo){
		//No es lo mismo que RetirarFrondos??
	}
}
