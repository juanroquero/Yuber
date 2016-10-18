package com.datatypes;


public class DataAdministradorBasico {

	private String AdministradorCorreo;
	private String AdministradorContraseña;
	private String AdministradorNombre;
		
	public DataAdministradorBasico() {
	}
	
	public DataAdministradorBasico(String AdministradorCorreo, String AdministradorNombre, String AdministradorContraseña){
		this.AdministradorCorreo 	= AdministradorCorreo;
		this.AdministradorNombre 	= AdministradorNombre;
		this.AdministradorContraseña= AdministradorContraseña;
	}
	
	public String getAdministradorCorreo() {
		return AdministradorCorreo;
	}

	public void setAdministradorCorreo(String administradorCorreo) {
		AdministradorCorreo = administradorCorreo;
	}

	public String getAdministradorContraseña() {
		return AdministradorContraseña;
	}

	public void setAdministradorContraseña(String administradorContraseña) {
		AdministradorContraseña = administradorContraseña;
	}

	public String getAdministradorNombre() {
		return AdministradorNombre;
	}

	public void setAdministradorNombre(String administradorNombre) {
		AdministradorNombre = administradorNombre;
	}
}
