package com.datatypes;

public class DataRese�a {
	
	private int Rese�aId;
	private DataInstanciaServicio InstanciaServicio;
	private String Rese�aComentario;
	private int Rese�aPuntaje;

	public DataRese�a() {
	}
	
	public DataRese�a(int rese�aId, DataInstanciaServicio instanciaServicio, String rese�aComentario, int rese�aPuntaje) {
		Rese�aId = rese�aId;
		InstanciaServicio = instanciaServicio;
		Rese�aComentario = rese�aComentario;
		Rese�aPuntaje = rese�aPuntaje;
	}

	public int getRese�aId() {
		return Rese�aId;
	}

	public void setRese�aId(int rese�aId) {
		Rese�aId = rese�aId;
	}

	public DataInstanciaServicio getInstanciaServicio() {
		return InstanciaServicio;
	}

	public void setInstanciaServicio(DataInstanciaServicio instanciaServicio) {
		InstanciaServicio = instanciaServicio;
	}

	public String getRese�aComentario() {
		return Rese�aComentario;
	}

	public void setRese�aComentario(String rese�aComentario) {
		Rese�aComentario = rese�aComentario;
	}

	public int getRese�aPuntaje() {
		return Rese�aPuntaje;
	}

	public void setRese�aPuntaje(int rese�aPuntaje) {
		Rese�aPuntaje = rese�aPuntaje;
	}

}
