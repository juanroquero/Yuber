package com.datatypes;

public class DataReseña {
	
	private int ReseñaId;
	private DataInstanciaServicio InstanciaServicio;
	private String ReseñaComentario;
	private int ReseñaPuntaje;

	public DataReseña() {
	}
	
	public DataReseña(int reseñaId, DataInstanciaServicio instanciaServicio, String reseñaComentario, int reseñaPuntaje) {
		ReseñaId = reseñaId;
		InstanciaServicio = instanciaServicio;
		ReseñaComentario = reseñaComentario;
		ReseñaPuntaje = reseñaPuntaje;
	}

	public int getReseñaId() {
		return ReseñaId;
	}

	public void setReseñaId(int reseñaId) {
		ReseñaId = reseñaId;
	}

	public DataInstanciaServicio getInstanciaServicio() {
		return InstanciaServicio;
	}

	public void setInstanciaServicio(DataInstanciaServicio instanciaServicio) {
		InstanciaServicio = instanciaServicio;
	}

	public String getReseñaComentario() {
		return ReseñaComentario;
	}

	public void setReseñaComentario(String reseñaComentario) {
		ReseñaComentario = reseñaComentario;
	}

	public int getReseñaPuntaje() {
		return ReseñaPuntaje;
	}

	public void setReseñaPuntaje(int reseñaPuntaje) {
		ReseñaPuntaje = reseñaPuntaje;
	}

}
