package com.datatypes;

public class DataInstanciaServicio {
	
	private int InstanciaServicioId;
	private float InstanciaServicioCosto;
	private float InstanciaServicioDistancia;
	private String InstanciaServicioFecha;
	private float InstanciaServicioTiempo;
	private DataReseña ReseñaCliente;
	private DataReseña ReseñaProveedor;	
	private DataServicio Servicio;
	private DataUsuario Usuario;

	public DataInstanciaServicio() {
	}

	public DataInstanciaServicio(int InstanciaServicioId, float InstanciaServicioCosto, float InstanciaServicioDistancia, String InstanciaServicioFecha, float InstanciaServicioTiempo, DataReseña ReseñaCliente, DataReseña ReseñaProveedor, DataServicio Servicio, DataUsuario Usuario) {
		this.InstanciaServicioId 		= InstanciaServicioId;
		this.InstanciaServicioCosto 	= InstanciaServicioCosto;
		this.InstanciaServicioDistancia	= InstanciaServicioDistancia;
		this.InstanciaServicioFecha		= InstanciaServicioFecha;
		this.InstanciaServicioTiempo	= InstanciaServicioTiempo;
		this.ReseñaCliente				= ReseñaCliente;
		this.ReseñaProveedor			= ReseñaProveedor;
		this.Servicio					= Servicio;
		this.Usuario					= Usuario;	
	}
	
	public int getInstanciaServicioId() {
		return InstanciaServicioId;
	}

	public void setInstanciaServicioId(int instanciaServicioId) {
		InstanciaServicioId = instanciaServicioId;
	}

	public float getInstanciaServicioCosto() {
		return InstanciaServicioCosto;
	}

	public void setInstanciaServicioCosto(float instanciaServicioCosto) {
		InstanciaServicioCosto = instanciaServicioCosto;
	}

	public float getInstanciaServicioDistancia() {
		return InstanciaServicioDistancia;
	}

	public void setInstanciaServicioDistancia(float instanciaServicioDistancia) {
		InstanciaServicioDistancia = instanciaServicioDistancia;
	}

	public String getInstanciaServicioFecha() {
		return InstanciaServicioFecha;
	}

	public void setInstanciaServicioFecha(String instanciaServicioFecha) {
		InstanciaServicioFecha = instanciaServicioFecha;
	}

	public float getInstanciaServicioTiempo() {
		return InstanciaServicioTiempo;
	}

	public void setInstanciaServicioTiempo(float instanciaServicioTiempo) {
		InstanciaServicioTiempo = instanciaServicioTiempo;
	}

	public DataReseña getReseñaCliente() {
		return ReseñaCliente;
	}

	public void setReseñaCliente(DataReseña reseñaCliente) {
		ReseñaCliente = reseñaCliente;
	}

	public DataReseña getReseñaProveedor() {
		return ReseñaProveedor;
	}

	public void setReseñaProveedor(DataReseña reseñaProveedor) {
		ReseñaProveedor = reseñaProveedor;
	}

	public DataServicio getServicio() {
		return Servicio;
	}

	public void setServicio(DataServicio servicio) {
		Servicio = servicio;
	}

	public DataUsuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(DataUsuario usuario) {
		Usuario = usuario;
	}
	
}
