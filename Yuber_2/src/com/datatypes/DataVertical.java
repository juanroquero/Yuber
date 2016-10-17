package com.datatypes;

import java.util.List;

public class DataVertical {
	
	private String VerticalTipo;
	private String VerticalNombre;
	private List<DataServicio> Servicios;
	private List<DataAdministrador> Administradores;
	
	public DataVertical() {
	}
	
	public DataVertical(String verticalTipo, String verticalNombre, List<DataServicio> servicios,
		List<DataAdministrador> administradores) {
		super();
		VerticalTipo = verticalTipo;
		VerticalNombre = verticalNombre;
		Servicios = servicios;
		Administradores = administradores;
	}
	
	public String getVerticalTipo() {
		return VerticalTipo;
	}
	
	public void setVerticalTipo(String verticalTipo) {
		VerticalTipo = verticalTipo;
	}
	
	public String getVerticalNombre() {
		return VerticalNombre;
	}
	
	public void setVerticalNombre(String verticalNombre) {
		VerticalNombre = verticalNombre;
	}
	
	public List<DataServicio> getServicios() {
		return Servicios;
	}
	
	public void setServicios(List<DataServicio> servicios) {
		Servicios = servicios;
	}

	public List<DataAdministrador> getAdministradores() {
		return Administradores;
	}

	public void setAdministradores(List<DataAdministrador> administradores) {
		Administradores = administradores;
	}

}
