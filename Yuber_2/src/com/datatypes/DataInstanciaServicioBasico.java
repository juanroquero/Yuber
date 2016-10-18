package com.datatypes;

public class DataInstanciaServicioBasico {
	
	private int InstanciaServicioId;
	private float InstanciaServicioCosto;
	private float InstanciaServicioDistancia;
	private String InstanciaServicioFecha;
	private float InstanciaServicioTiempo;

	public DataInstanciaServicioBasico() {
	}

	public DataInstanciaServicioBasico(int InstanciaServicioId, float InstanciaServicioCosto, float InstanciaServicioDistancia, String InstanciaServicioFecha, float InstanciaServicioTiempo) {
		this.InstanciaServicioId 		= InstanciaServicioId;
		this.InstanciaServicioCosto 	= InstanciaServicioCosto;
		this.InstanciaServicioDistancia	= InstanciaServicioDistancia;
		this.InstanciaServicioFecha		= InstanciaServicioFecha;
		this.InstanciaServicioTiempo	= InstanciaServicioTiempo;
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
	
}
