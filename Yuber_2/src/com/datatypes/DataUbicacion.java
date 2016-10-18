package com.datatypes;

public class DataUbicacion {
	
	private String Estado = "Ok";
	private String Longitud;
	private String Latitud;
	
	public DataUbicacion(){
	}
	
	public DataUbicacion(String Longitud, String Latitud){
		this.Longitud = Longitud;
		this.Latitud = Latitud;
	}
	
	public String getLongitud() {
		return Longitud;
	}
	
	public void setLongitud(String longitud) {
		Longitud = longitud;
	}
	
	public String getLatitud() {
		return Latitud;
	}
	
	public void setLatitud(String latitud) {
		Latitud = latitud;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	
	
}
