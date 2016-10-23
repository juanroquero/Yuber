package com.webservices;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.datatypes.DataInstanciaServicio;
import com.datatypes.DataProveedor;
import com.datatypes.DataReseña;

@Path("/Proveedores")
public interface ControladorProveedorWS {

	@GET
	@Path("/PuntuarProveedor/{puntaje},{comentario},{instanciaServicioId}")
	@Produces(MediaType.APPLICATION_JSON)
	String PuntuarProveedor(@PathParam ("puntaje") int Puntaje, @PathParam ("comentario") String Comentario, @PathParam ("instanciaServicioId") int InstanciaServicioId);

	@POST
	@Path("/RegistrarProveedor")
	@Consumes(MediaType.APPLICATION_JSON)
	void RegistrarProveedor(DataProveedor Proveedor);

	@GET
	@Path("/Login/{proveedorCorreo},{password}")
	@Produces(MediaType.APPLICATION_JSON)
	boolean Login(@PathParam ("proveedorCorreo") String ProveedorCorreo, @PathParam ("password") String Password);

	@GET
	@Path("/AceptarServicio/{instanciaServicioId},{correo}")
	@Produces(MediaType.APPLICATION_JSON)
	String AceptarServicio(@PathParam ("instanciaServicioId") int InstanciaServicioId, @PathParam ("correo") String Correo);

	@GET
	@Path("/RechazarServicio/{instanciaServicioId}")
	void RechazarServicio(@PathParam ("instanciaServicioId") int InstanciaServicioId);

	@GET
	@Path("/IniciarJornada/{instanciaServicioId},{servicioId}")
	@Produces(MediaType.APPLICATION_JSON)
	String IniciarJornada(@PathParam ("proveedorCorreo") String ProveedorCorreo, @PathParam ("servicioId") int ServicioId);

	@GET
	@Path("/FinalizarJornada/{instanciaServicioId},{servicioId}")
	@Produces(MediaType.APPLICATION_JSON)
	String FinalizarJornada(@PathParam ("proveedorCorreo") String ProveedorCorreo, @PathParam ("servicioId") int ServicioId);

	@GET
	@Path("/MisReseñasObtenidas/{proveedorCorreo}")
	@Produces(MediaType.APPLICATION_JSON)
	List<DataReseña> MisReseñasObtenidas(@PathParam ("proveedorCorreo") String ProveedorCorreo);

	@GET
	@Path("/RetirarFondos/{proveedorCorreo}")
	@Produces(MediaType.APPLICATION_JSON)
	void RetirarFondos(@PathParam ("proveedorCorreo") String ProveedorCorreo);

	@GET
	@Path("/ObtenerHistorial/{proveedorCorreo}")
	@Produces(MediaType.APPLICATION_JSON)
	List<DataInstanciaServicio> ObtenerHistorial(@PathParam ("proveedorCorreo") String ProveedorCorreo);

	@GET
	@Path("/NotificarArribo/{instanciaServicioId}")
	@Produces(MediaType.APPLICATION_JSON)
	void NotificarArribo(@PathParam ("instanciaServicioId") int InstanciaServicioId);

	@GET
	@Path("/AsociarServicio/{proveedorCorreo},{servicioId}")
	@Produces(MediaType.APPLICATION_JSON)
	String AsociarServicio(@PathParam ("proveedorCorreo") String ProveedorCorreo, @PathParam ("servicioId") int ServicioId);

	@GET
	@Path("/NotificarArribo/{instanciaServicioId}")
	@Produces(MediaType.APPLICATION_JSON)
	String IniciarServicio(@PathParam ("instanciaServicioId") int InstanciaServicioId);
	
	@GET
	@Path("/NotificarArribo/{instanciaServicioId},{distancia}")
	@Produces(MediaType.APPLICATION_JSON)
	String FinServicio(@PathParam ("instanciaServicioId") int InstanciaServicioId, @PathParam ("distancia") float Distancia);

	@GET
	@Path("/OlvidePass/{proveedorCorreo}")
	@Produces(MediaType.APPLICATION_JSON)
	boolean OlvidePass(@PathParam ("proveedorCorreo") String ProveedorCorreo);

	@GET
	@Path("/OlvidePass/{proveedorCorreo},{medioDePago}")
	@Produces(MediaType.APPLICATION_JSON)
	void AsociarMecanismoDePago(@PathParam ("proveedorCorreo") String ProveedorCorreo,@PathParam ("medioDePago") String MedioDePago);

	@GET
	@Path("/Cobrar/{proveedorCorreo}")
	@Produces(MediaType.APPLICATION_JSON)
	void Cobrar(@PathParam ("proveedorCorreo") String ProveedorCorreo);

}