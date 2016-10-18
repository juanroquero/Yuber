package com.datatypes;

import java.util.Date;

public class DataInstanciaServicio {
	
	private int InstanciaServicioId;
	private float InstanciaServicioCosto;
	private float InstanciaServicioDistancia;
	private Date InstanciaServicioFechaInicio;
	private Date InstanciaServicioFechaFin;
	private float InstanciaServicioTiempo;
	private DataUbicacion Ubicacion;
	private DataReseña ReseñaCliente;
	private DataReseña ReseñaProveedor;	
	private DataServicio Servicio;
	private DataCliente Cliente;
	private DataProveedor Proveedor;

	public DataInstanciaServicio() {
	}

	public DataInstanciaServicio(int InstanciaServicioId, float InstanciaServicioCosto, float InstanciaServicioDistancia, Date InstanciaServicioFechaInicio, Date InstanciaServicioFechaFin, float InstanciaServicioTiempo, DataUbicacion Ubicacion, DataReseña ReseñaCliente, DataReseña ReseñaProveedor, DataServicio Servicio, DataCliente Cliente, DataProveedor Proveedor) {
		this.InstanciaServicioId 			= InstanciaServicioId;
		this.InstanciaServicioCosto 		= InstanciaServicioCosto;
		this.InstanciaServicioDistancia		= InstanciaServicioDistancia;
		this.InstanciaServicioFechaInicio	= InstanciaServicioFechaInicio;
		this.InstanciaServicioFechaFin  	= InstanciaServicioFechaFin;
		this.InstanciaServicioTiempo		= InstanciaServicioTiempo;
		this.Ubicacion						= Ubicacion;
		this.ReseñaCliente					= ReseñaCliente;
		this.ReseñaProveedor				= ReseñaProveedor;
		this.Servicio						= Servicio;
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

	public DataCliente getCliente() {
		return Cliente;
	}

	public void setCliente(DataCliente cliente) {
		Cliente = cliente;
	}

	public DataProveedor getProveedor() {
		return Proveedor;
	}

	public void setProveedor(DataProveedor proveedor) {
		Proveedor = proveedor;
	}

	public DataUbicacion getUbicacion() {
		return Ubicacion;
	}

	public void setUbicacion(DataUbicacion ubicacion) {
		Ubicacion = ubicacion;
	}

	public Date getInstanciaServicioFechaInicio() {
		return InstanciaServicioFechaInicio;
	}

	public void setInstanciaServicioFechaInicio(Date instanciaServicioFechaInicio) {
		InstanciaServicioFechaInicio = instanciaServicioFechaInicio;
	}

	public Date getInstanciaServicioFechaFin() {
		return InstanciaServicioFechaFin;
	}

	public void setInstanciaServicioFechaFin(Date instanciaServicioFechaFin) {
		InstanciaServicioFechaFin = instanciaServicioFechaFin;
	}

	

	
	
}
