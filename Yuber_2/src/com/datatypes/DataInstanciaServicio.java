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
	private DataRese�a Rese�aCliente;
	private DataRese�a Rese�aProveedor;	
	private DataServicio Servicio;
	private DataCliente Cliente;
	private DataProveedor Proveedor;

	public DataInstanciaServicio() {
	}

	public DataInstanciaServicio(int InstanciaServicioId, float InstanciaServicioCosto, float InstanciaServicioDistancia, Date InstanciaServicioFechaInicio, Date InstanciaServicioFechaFin, float InstanciaServicioTiempo, DataUbicacion Ubicacion, DataRese�a Rese�aCliente, DataRese�a Rese�aProveedor, DataServicio Servicio, DataCliente Cliente, DataProveedor Proveedor) {
		this.InstanciaServicioId 			= InstanciaServicioId;
		this.InstanciaServicioCosto 		= InstanciaServicioCosto;
		this.InstanciaServicioDistancia		= InstanciaServicioDistancia;
		this.InstanciaServicioFechaInicio	= InstanciaServicioFechaInicio;
		this.InstanciaServicioFechaFin  	= InstanciaServicioFechaFin;
		this.InstanciaServicioTiempo		= InstanciaServicioTiempo;
		this.Ubicacion						= Ubicacion;
		this.Rese�aCliente					= Rese�aCliente;
		this.Rese�aProveedor				= Rese�aProveedor;
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
