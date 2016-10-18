package com.datatypes;


public class DataServicioBasico {
	
	private int ServicioId;
	private String ServicioNombre;
	private float ServicioPrecioHora;
	private float ServicioPrecioKM;
	private float ServicioTarifaBase;
	
	public DataServicioBasico() {
	}

	public DataServicioBasico(int servicioId, String servicioNombre, float servicioPrecioHora, float servicioPrecioKM,
		float servicioTarifaBase) {
		ServicioId = servicioId;
		ServicioNombre = servicioNombre;
		ServicioPrecioHora = servicioPrecioHora;
		ServicioPrecioKM = servicioPrecioKM;
		ServicioTarifaBase = servicioTarifaBase;
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

}