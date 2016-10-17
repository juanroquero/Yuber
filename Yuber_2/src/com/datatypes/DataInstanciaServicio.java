package com.datatypes;

public class DataInstanciaServicio {
	
	private int InstanciaServicioId;
	private float InstanciaServicioCosto;
	private float InstanciaServicioDistancia;
	private String InstanciaServicioFecha;
	private float InstanciaServicioTiempo;
	private DataRese�a Rese�aCliente;
	private DataRese�a Rese�aProveedor;	
	private DataServicio Servicio;
	private DataUsuario Usuario;

	public DataInstanciaServicio() {
	}

	public DataInstanciaServicio(int InstanciaServicioId, float InstanciaServicioCosto, float InstanciaServicioDistancia, String InstanciaServicioFecha, float InstanciaServicioTiempo, DataRese�a Rese�aCliente, DataRese�a Rese�aProveedor, DataServicio Servicio, DataUsuario Usuario) {
		this.InstanciaServicioId 		= InstanciaServicioId;
		this.InstanciaServicioCosto 	= InstanciaServicioCosto;
		this.InstanciaServicioDistancia	= InstanciaServicioDistancia;
		this.InstanciaServicioFecha		= InstanciaServicioFecha;
		this.InstanciaServicioTiempo	= InstanciaServicioTiempo;
		this.Rese�aCliente				= Rese�aCliente;
		this.Rese�aProveedor			= Rese�aProveedor;
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

	public DataRese�a getRese�aCliente() {
		return Rese�aCliente;
	}

	public void setRese�aCliente(DataRese�a rese�aCliente) {
		Rese�aCliente = rese�aCliente;
	}

	public DataRese�a getRese�aProveedor() {
		return Rese�aProveedor;
	}

	public void setRese�aProveedor(DataRese�a rese�aProveedor) {
		Rese�aProveedor = rese�aProveedor;
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
