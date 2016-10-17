package com.controladores;
import java.util.List;

import javax.persistence.EntityManager;
import com.datatypes.*;
public class ControladorCliente {

	EntityManager em;
	
	public ControladorCliente() {
	}
	
	public void PuntuarCliente(String ClienteCorreo, int Puntaje){		
	}
	
	public List<DataCliente> ObtenerClientes(){	
		return null;
	}
	
	public List<DataInstanciaServicio> ObtenerHistorial(String ClienteCorreo, int ServicioId){		
		return null;
	}
	
	public List<DataReseña> ReseñaServicios(String ClienteCorreo){
		return null;
	}
	
	public void CancelarPedido(String InstanciaServicioId){		
	}
	
	public void FinServicio(String InstanciaServicioId){		
	}
	
	public void OlvidePass(String CienteCorreo){		
	}
	
	public void RegistrarCliente(DataCliente Cliente){		
	}
	
	public void AsociarMecanismoDePago(String ClienteCorreo, String MedioDePago){		
	//Este parece no estar bien definido, hay que ver bien como se maneja el asociar paypal
	}
	
	public int PedirServicio(String ClienteCorreo, int ServicioId, String Ubicacion){		
		return 0;
	}
	
	public void Login(String ClienteEmail, String Password){		
	}
}
