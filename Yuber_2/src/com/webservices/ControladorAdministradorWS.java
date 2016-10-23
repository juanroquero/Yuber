package com.webservices;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.datatypes.DataAdministrador;
import com.datatypes.DataAdministradorBasico;
import com.datatypes.DataClienteBasico;
import com.datatypes.DataProveedorBasico;
import com.datatypes.DataVerticalBasico;


@Path("/Administrador")
public interface ControladorAdministradorWS {

	void Login(String AdministradorEmail, String Password);

	@GET
	@Path("/ObtenerClientesActivos")
	@Produces(MediaType.APPLICATION_JSON)
	List<DataClienteBasico> ObtenerClientesActivos();

	@GET
	@Path("/ObtenerProveedoresActivos")
	@Produces(MediaType.APPLICATION_JSON)
	List<DataProveedorBasico> ObtenerProveedoresActivos();

	@POST
	@Path("/CrearAdministrador")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	String CrearAdministrador(DataAdministradorBasico Administrador);

	@GET
	@Path("/EliminarAdministrador/{adminEmail}")
	@Produces(MediaType.APPLICATION_JSON)
	String EliminarAdministrador(@PathParam ("adminEmail") String AdministradorEmail);
	
	@POST
	@Path("/ModificarAdministrador")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	String ModificarAdministrador(DataAdministradorBasico Administrador);
	
	@GET
	@Path("/ObtenerAdministrador/{adminMail}")
	@Produces(MediaType.APPLICATION_JSON)
	DataAdministrador ObtenerAdministrador(@PathParam ("adminMail") String AdministradorEmail);

	@GET
	@Path("/TopProveedoresPorPuntajes/{fecha}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	float ObtenerGananciaMensual(@PathParam ("fecha") Date fecha);

	@GET
	@Path("/TopProveedoresPorPuntajes/{limit}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	List<DataProveedorBasico> TopProveedoresPorPuntajes(@PathParam ("limit") int Limit);

	@GET
	@Path("/TopProveedoresPorGanancia/{limit}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	List<DataProveedorBasico> TopProveedoresPorGanancia(@PathParam ("limit") int Limit);

	@GET
	@Path("/TopClientesPorPuntaje/{limit}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	List<DataClienteBasico> TopClientesPorPuntaje(@PathParam ("limit") int Limit);

	@POST
	@Path("/CrearVertical")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	String CrearVertical(DataVerticalBasico Vertical);

	@GET
	@Path("/TopClientesPorPuntaje/{adminCreadorId},{adminId},{TipoVertical}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	String AsignarVertical(@PathParam ("adminCreadorId") String AdminCreadorId, @PathParam ("adminId") String AdminId, @PathParam ("tipoVertical") String TipoVertical);

	@GET
	@Path("/TopClientesPorPuntaje/{adminCreadorId},{adminId},{TipoVertical}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	String DenegarVertical(@PathParam ("adminCreadorId") String AdminCreadorId, @PathParam ("adminId") String AdminId, @PathParam ("tipoVertical") String TipoVertical);

}