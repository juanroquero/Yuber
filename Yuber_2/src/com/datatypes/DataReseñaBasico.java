package com.datatypes;

public class DataReseñaBasico {
	
	private int ReseñaId;
	private String ReseñaComentario;
	private int ReseñaPuntaje;

	public DataReseñaBasico() {
	}
	
	public DataReseñaBasico(int reseñaId, String reseñaComentario, int reseñaPuntaje) {
		ReseñaId = reseñaId;
		ReseñaComentario = reseñaComentario;
		ReseñaPuntaje = reseñaPuntaje;
	}

	public int getReseñaId() {
		return ReseñaId;
	}

	public void setReseñaId(int reseñaId) {
		ReseñaId = reseñaId;
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
