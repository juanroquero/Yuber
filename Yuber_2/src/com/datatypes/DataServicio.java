package com.datatypes;

import java.util.List;

public class DataServicio {
	
	private int ServicioId;
	private String ServicioNombre;
	private float ServicioPrecioHora;
	private float ServicioPrecioKM;
	private float ServicioTarifaBase;
	private List<DataInstanciaServicio> InstanciasServicio;
	private DataVertical Vertical;
	private List<DataProveedor> Proveedores;
	
	public DataServicio() {
	}

	public DataServicio(int servicioId, String servicioNombre, float servicioPrecioHora, float servicioPrecioKM,
		float servicioTarifaBase, List<DataInstanciaServicio> instanciasServicio, DataVertical vertical,
		List<DataProveedor> proveedores) {
		ServicioId = servicioId;
		ServicioNombre = servicioNombre;
		ServicioPrecioHora = servicioPrecioHora;
		ServicioPrecioKM = servicioPrecioKM;
		ServicioTarifaBase = servicioTarifaBase;
		InstanciasServicio = instanciasServicio;
		Vertical = vertical;
		Proveedores = proveedores;
	}
	
	public int getServicioId() {
		return ServicioId;
	}

	public void setServicioId(int servicioId) {
		ServicioId = servicioId;
	}

	public String getServicioNombre() {
		return ServicioNombre;
	}

	public void setServicioNombre(String servicioNombre) {
		ServicioNombre = servicioNombre;
	}

	public float getServicioPrecioHora() {
		return ServicioPrecioHora;
	}

	public void setServicioPrecioHora(float servicioPrecioHora) {
		ServicioPrecioHora = servicioPrecioHora;
	}

	public float getServicioPrecioKM() {
		return ServicioPrecioKM;
	}

	public void setServicioPrecioKM(float servicioPrecioKM) {
		ServicioPrecioKM = servicioPrecioKM;
	}

	public float getServicioTarifaBase() {
		return ServicioTarifaBase;
	}

	public void setServicioTarifaBase(float servicioTarifaBase) {
		ServicioTarifaBase = servicioTarifaBase;
	}

	public List<DataInstanciaServicio> getInstanciasServicio() {
		return InstanciasServicio;
	}

	public void setInstanciasServicio(List<DataInstanciaServicio> instanciasServicio) {
		InstanciasServicio = instanciasServicio;
	}

	public DataVertical getVertical() {
		return Vertical;
	}

	public void setVertical(DataVertical vertical) {
		Vertical = vertical;
	}

	public List<DataProveedor> getProveedores() {
		return Proveedores;
	}

	public void setProveedores(List<DataProveedor> proveedores) {
		Proveedores = proveedores;
	}

}
