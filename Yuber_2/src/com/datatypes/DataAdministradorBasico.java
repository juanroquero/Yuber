package com.datatypes;


public class DataAdministradorBasico {

	private String AdministradorCorreo;
	private String AdministradorContrase�a;
	private String AdministradorNombre;
		
	public DataAdministradorBasico() {
	}
	
	public DataAdministradorBasico(String AdministradorCorreo, String AdministradorNombre, String AdministradorContrase�a){
		this.AdministradorCorreo 	= AdministradorCorreo;
		this.AdministradorNombre 	= AdministradorNombre;
		this.AdministradorContrase�a= AdministradorContrase�a;
	}
	
	public String getAdministradorCorreo() {
		return AdministradorCorreo;
	}

	public void setAdministradorCorreo(String administradorCorreo) {
		AdministradorCorreo = administradorCorreo;
	}

	public String getAdministradorContrase�a() {
		return AdministradorContrase�a;
	}

	public void setAdministradorContrase�a(String administradorContrase�a) {
		AdministradorContrase�a = administradorContrase�a;
	}

	public String getAdministradorNombre() {
		return AdministradorNombre;
	}

	public void setAdministradorNombre(String administradorNombre) {
		AdministradorNombre = administradorNombre;
	}
}
