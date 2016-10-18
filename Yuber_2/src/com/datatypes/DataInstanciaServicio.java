package com.datatypes;

public class DataInstanciaServicio {
	
	private int InstanciaServicioId;
	private float InstanciaServicioCosto;
	private float InstanciaServicioDistancia;
	private String InstanciaServicioFecha;
	private float InstanciaServicioTiempo;
	private DataReseñaBasico ReseñaCliente;
	private DataReseñaBasico ReseñaProveedor;	
	private DataServicioBasico Servicio;
	private DataClienteBasico Cliente;
	private DataProveedorBasico Proveedor;

	public DataInstanciaServicio() {
	}

	public DataInstanciaServicio(int InstanciaServicioId, float InstanciaServicioCosto, float InstanciaServicioDistancia, String InstanciaServicioFecha, float InstanciaServicioTiempo, DataReseñaBasico ReseñaCliente, DataReseñaBasico ReseñaProveedor, DataServicioBasico Servicio, DataClienteBasico Cliente, DataProveedorBasico Proveedor) {
		this.InstanciaServicioId 		= InstanciaServicioId;
		this.InstanciaServicioCosto 	= InstanciaServicioCosto;
		this.InstanciaServicioDistancia	= InstanciaServicioDistancia;
		this.InstanciaServicioFecha		= InstanciaServicioFecha;
		this.InstanciaServicioTiempo	= InstanciaServicioTiempo;
		this.ReseñaCliente				= ReseñaCliente;
		this.ReseñaProveedor			= ReseñaProveedor;
		this.Servicio					= Servicio;
		this.setCliente(Cliente);
		this.setProveedor(Proveedor);
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

	public DataReseñaBasico getReseñaCliente() {
		return ReseñaCliente;
	}

	public void setReseñaCliente(DataReseñaBasico reseñaCliente) {
		ReseñaCliente = reseñaCliente;
	}

	public DataReseñaBasico getReseñaProveedor() {
		return ReseñaProveedor;
	}

	public void setReseñaProveedor(DataReseñaBasico reseñaProveedor) {
		ReseñaProveedor = reseñaProveedor;
	}

	public DataServicioBasico getServicio() {
		return Servicio;
	}

	public void setServicio(DataServicioBasico servicio) {
		Servicio = servicio;
	}

	public DataClienteBasico getCliente() {
		return Cliente;
	}

	public void setCliente(DataClienteBasico cliente) {
		Cliente = cliente;
	}

	public DataProveedorBasico getProveedor() {
		return Proveedor;
	}

	public void setProveedor(DataProveedorBasico proveedor) {
		Proveedor = proveedor;
	}

	
	
}
