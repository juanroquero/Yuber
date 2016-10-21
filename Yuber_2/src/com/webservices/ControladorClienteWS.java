package com.webservices;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.datatypes.DataCliente;
import com.datatypes.DataInstanciaServicio;
import com.datatypes.DataReseña;
import com.datatypes.DataUbicacion;

public interface ControladorClienteWS {

	String PuntuarCliente(int Puntaje, String Comentario, int InstanciaServicioId);

	List<DataCliente> ObtenerClientes();

	List<DataInstanciaServicio> ObtenerHistorial(String ClienteCorreo, int ServicioId);

	List<DataReseña> MisReseñasObtenidas(String ClienteCorreo);

	String CancelarPedido(int InstanciaServicioId);

	boolean OlvidePass(String CienteCorreo);

	void RegistrarCliente(DataCliente Cliente);

	void AsociarMecanismoDePago(String ClienteCorreo, String MedioDePago);

	int PedirServicio(String ClienteCorreo, int ServicioId, DataUbicacion DataUbicacion);

	boolean Login(String ClienteEmail, String Password);

}