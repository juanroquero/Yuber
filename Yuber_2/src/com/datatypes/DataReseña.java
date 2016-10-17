package com.datatypes;

public class DataReseņa {
	
	private int ReseņaId;
	private DataInstanciaServicio InstanciaServicio;
	private String ReseņaComentario;
	private int ReseņaPuntaje;

	public DataReseņa() {
	}
	
	public DataReseņa(int reseņaId, DataInstanciaServicio instanciaServicio, String reseņaComentario, int reseņaPuntaje) {
		ReseņaId = reseņaId;
		InstanciaServicio = instanciaServicio;
		ReseņaComentario = reseņaComentario;
		ReseņaPuntaje = reseņaPuntaje;
	}

	public int getReseņaId() {
		return ReseņaId;
	}

	public void setReseņaId(int reseņaId) {
		ReseņaId = reseņaId;
	}

	public DataInstanciaServicio getInstanciaServicio() {
		return InstanciaServicio;
	}

	public void setInstanciaServicio(DataInstanciaServicio instanciaServicio) {
		InstanciaServicio = instanciaServicio;
	}

	public String getReseņaComentario() {
		return ReseņaComentario;
	}

	public void setReseņaComentario(String reseņaComentario) {
		ReseņaComentario = reseņaComentario;
	}

	public int getReseņaPuntaje() {
		return ReseņaPuntaje;
	}

	public void setReseņaPuntaje(int reseņaPuntaje) {
		ReseņaPuntaje = reseņaPuntaje;
	}

}
