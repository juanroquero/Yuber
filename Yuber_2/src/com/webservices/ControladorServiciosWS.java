package com.webservices;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.datatypes.DataServicio;
import com.datatypes.DataServicioBasico;

@Path("/Servicios")
public interface ControladorServiciosWS {
	
	@GET
	@Path("/ObtenerServicios/{tipoDeVertical}")
	@Produces(MediaType.APPLICATION_JSON)
	List<DataServicio> ObtenerServicios(@PathParam ("tipoVertical") String TipoDeVertical);

	//Creo que hay que pasar un solo datatype con todo. El gey y el post no soportan esto asi como esta
	String CrearServicio(DataServicioBasico Servicio, String TipoVertical);

	@GET
	@Path("/EliminarServicio/{servicioId}")
	@Produces(MediaType.APPLICATION_JSON)
	String EliminarServicio(@PathParam ("servicioId") int ServicioId);

	@POST
	@Path("/ModificarServicio")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	String ModificarServicio(DataServicioBasico Servicio);
	
	@GET
	@Path("/EliminarServicio/{servicioId}")
	@Produces(MediaType.APPLICATION_JSON)
	DataServicio ObtenerServicio(@PathParam ("servicioId") int ServicioId);

}