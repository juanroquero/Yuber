package com.webservices;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.datatypes.DataCliente;
import com.datatypes.DataInstanciaServicio;
import com.datatypes.DataReseña;
import com.datatypes.DataUbicacion;


@Path("/Clientes")
public interface ControladorClienteWS {

	@GET
	@Path("/PuntuarCliente/{puntaje},{comentario},{instanciaServicioId}")
	@Produces(MediaType.APPLICATION_JSON)
	String PuntuarCliente(@PathParam ("puntaje") int Puntaje, @PathParam ("comentario") String Comentario, @PathParam ("instanciaServicioId") int InstanciaServicioId);

	@GET
	@Path("/ObtenerClientes")
	@Produces(MediaType.APPLICATION_JSON)
	List<DataCliente> ObtenerClientes();

	@GET
	@Path("/ObtenerHistorial/{clienteCorreo},{servicioId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<DataInstanciaServicio> ObtenerHistorial(@PathParam ("clienteCorreo") String ClienteCorreo, @PathParam ("servicioId") int ServicioId);

	@GET
	@Path("/MisReseñasObtenidas/{clienteCorreo}")
	@Produces(MediaType.APPLICATION_JSON)
	List<DataReseña> MisReseñasObtenidas(@PathParam ("clienteCorreo") String ClienteCorreo);

	@GET
	@Path("/CancelarPedido/{instanciaServicioId}")
	@Produces(MediaType.APPLICATION_JSON)
	String CancelarPedido(@PathParam ("instanciaServicioId") int InstanciaServicioId);

	@GET
	@Path("/OlvidePass/{clienteCorreo}")
	@Produces(MediaType.APPLICATION_JSON)
	boolean OlvidePass(@PathParam ("clienteCorreo") String CienteCorreo);

	@POST
	@Path("/RegistrarCliente")
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	void RegistrarCliente(DataCliente Cliente);

	void AsociarMecanismoDePago(String ClienteCorreo, String MedioDePago);

	int PedirServicio(String ClienteCorreo, int ServicioId, DataUbicacion DataUbicacion);
	
	@GET
	@Path("/Login/{clienteCorreo},{password}")
	@Produces(MediaType.APPLICATION_JSON)
	boolean Login(@PathParam ("clienteCorreo") String ClienteCorreo, @PathParam ("password") String Password);

}