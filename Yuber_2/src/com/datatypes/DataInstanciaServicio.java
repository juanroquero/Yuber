package com.datatypes;

import java.util.Date;

public class DataInstanciaServicio {
	
	private String Estado = "Ok";
	private int InstanciaServicioId;
	private float InstanciaServicioCosto;
	private float InstanciaServicioDistancia;
	private Date InstanciaServicioFechaInicio;
	private Date InstanciaServicioFechaFin;
	private float InstanciaServicioTiempo;
	private DataUbicacion Ubicacion;
	private DataRese�aBasico Rese�aCliente;
	private DataRese�aBasico Rese�aProveedor;	
	private DataServicioBasico Servicio;
	private DataClienteBasico Cliente;
	private DataProveedorBasico Proveedor;

	public DataInstanciaServicio() {
	}

	public DataInstanciaServicio(int InstanciaServicioId, float InstanciaServicioCosto, float InstanciaServicioDistancia, Date InstanciaServicioFechaInicio, Date InstanciaServicioFechaFin, float InstanciaServicioTiempo, DataUbicacion Ubicacion, DataRese�aBasico Rese�aCliente, DataRese�aBasico Rese�aProveedor, DataServicioBasico Servicio, DataClienteBasico Cliente, DataProveedorBasico Proveedor) {
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

	public DataRese�aBasico getRese�aCliente() {
		return Rese�aCliente;
	}

	public void setRese�aCliente(DataRese�aBasico rese�aCliente) {
		Rese�aCliente = rese�aCliente;
	}

	public DataRese�aBasico getRese�aProveedor() {
		return Rese�aProveedor;
	}

	public void setRese�aProveedor(DataRese�aBasico rese�aProveedor) {
		Rese�aProveedor = rese�aProveedor;
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

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	

	
	
}
