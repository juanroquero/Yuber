package com.webservices;

import java.util.List;

import com.datatypes.DataInstanciaServicio;
import com.datatypes.DataProveedor;
import com.datatypes.DataReseña;

public interface ControladorProveedorWS {

	String PuntuarProveedor(int Puntaje, String Comentario, int InstanciaServicioId);

	void RegistrarProveedor(DataProveedor Proveedor);

	void Login(String ProveedorEmail, String Password);

	String AceptarServicio(int InstanciaServicioId, String Correo);

	void RechazarServicio(int InstanciaServicioId);

	String IniciarJornada(String ProveedorCorreo, int ServicioId);

	String FinalizarJornada(String ProveedorCorreo, int ServicioId);

	List<DataReseña> ReseñaServicios(String ProveedorCorreo);

	void RetirarFondos(String ProveedorCorreo);

	List<DataInstanciaServicio> ObtenerHistorial(String ProveedorCorreo);

	void NotificarArribo(int InstanciaServicioId);

	String AsociarServicio(String ProveedorCorreo, int ServicioId);

	String IniciarServicio(int InstanciaServicioId);

	String FinServicio(int InstanciaServicioId, float Costo, float Distancia, float Tiempo);

	boolean OlvidePass(String ClienteCorreo);

	void AsociarMecanismoDePago(String ProveedorCorreo, String MedioDePago);

	void Cobrar(String ProveedorCorreo);

}