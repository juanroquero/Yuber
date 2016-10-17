package com.datatypes;

import java.util.ArrayList;
import java.util.List;

public class DataAdministrador {

	private String AdministradorCorreo;
	private String AdministradorContrase�a;
	private String AdministradorNombre;
	private List<DataVertical> Verticales = new ArrayList<DataVertical>();
		
	public DataAdministrador() {
	}
	
	public DataAdministrador(String AdministradorCorreo, String AdministradorNombre, String AdministradorContrase�a, List<DataVertical> DataVertical){
		this.AdministradorCorreo 	= AdministradorCorreo;
		this.AdministradorNombre 	= AdministradorNombre;
		this.AdministradorContrase�a= AdministradorContrase�a;
		this.Verticales = DataVertical;
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

	public List<DataVertical> getVerticales() {
		return Verticales;
	}

	public void setVerticales(List<DataVertical> Verticales) {
		this.Verticales = Verticales;
	}

}
