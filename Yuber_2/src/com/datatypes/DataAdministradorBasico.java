package com.datatypes;


public class DataAdministradorBasico {

	private String Estado = "Ok";
	private String AdministradorCorreo;
	private String AdministradorContraseņa;
	private String AdministradorNombre;
		
	public DataAdministradorBasico() {
	}
	
	public DataAdministradorBasico(String AdministradorCorreo, String AdministradorNombre, String AdministradorContraseņa){
		this.AdministradorCorreo 	= AdministradorCorreo;
		this.AdministradorNombre 	= AdministradorNombre;
		this.AdministradorContraseņa= AdministradorContraseņa;
	}
	
	public String getAdministradorCorreo() {
		return AdministradorCorreo;
	}

	public void setAdministradorCorreo(String administradorCorreo) {
		AdministradorCorreo = administradorCorreo;
	}

	public String getAdministradorContraseņa() {
		return AdministradorContraseņa;
	}

	public void setAdministradorContraseņa(String administradorContraseņa) {
		AdministradorContraseņa = administradorContraseņa;
	}

	public String getAdministradorNombre() {
		return AdministradorNombre;
	}

	public void setAdministradorNombre(String administradorNombre) {
		AdministradorNombre = administradorNombre;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}
}
