package com.datatypes;

import java.util.List;

public class DataProveedor {
	
	private String UsuarioCorreo;
	private String UsuarioNombre;
	private String UsuarioApellido;
	private String UsuarioCiudad;
	private String UsuarioContraseña;
	private String UsuarioDireccion;	
	private float UsuarioPromedioPuntaje;
	private int UsuarioTelefono;
	private List<DataInstanciaServicio> InstanciasServicio;
	private DataServicio Servicio;
	
	public DataProveedor() {
	}
	
	public DataProveedor(String UsuarioCorreo, String UsuarioNombre, String UsuarioApellido, String UsuarioCiudad, String UsuarioContraseña, String UsuarioDireccion, float UsuarioPromedioPuntaje, int UsuarioTelefono, List<DataInstanciaServicio> InstanciasServicio, DataServicio Servicio) {
		this.UsuarioCorreo 			= UsuarioCorreo;
		this.UsuarioNombre 			= UsuarioNombre;
		this.UsuarioApellido		= UsuarioApellido;
		this.UsuarioCiudad			= UsuarioCiudad;
		this.UsuarioContraseña		= UsuarioContraseña;
		this.UsuarioDireccion		= UsuarioDireccion;
		this.UsuarioTelefono		= UsuarioTelefono;
		this.UsuarioPromedioPuntaje	= UsuarioPromedioPuntaje;
		this.InstanciasServicio		= InstanciasServicio;	
		this.Servicio				= Servicio;
	}
	
	public String getUsuarioCorreo() {
		return UsuarioCorreo;
	}
	
	public void setUsuarioCorreo(String usuarioCorreo) {
		UsuarioCorreo = usuarioCorreo;
	}
	
	public String getUsuarioNombre() {
		return UsuarioNombre;
	}
	
	public void setUsuarioNombre(String usuarioNombre) {
		UsuarioNombre = usuarioNombre;
	}
	
	public String getUsuarioApellido() {
		return UsuarioApellido;
	}
	
	public void setUsuarioApellido(String usuarioApellido) {
		UsuarioApellido = usuarioApellido;
	}
	
	public String getUsuarioCiudad() {
		return UsuarioCiudad;
	}
	
	public void setUsuarioCiudad(String usuarioCiudad) {
		UsuarioCiudad = usuarioCiudad;
	}
	
	public String getUsuarioContraseña() {
		return UsuarioContraseña;
	}
	
	public void setUsuarioContraseña(String usuarioContraseña) {
		UsuarioContraseña = usuarioContraseña;
	}
	
	public String getUsuarioDireccion() {
		return UsuarioDireccion;
	}
	
	public void setUsuarioDireccion(String usuarioDireccion) {
		UsuarioDireccion = usuarioDireccion;
	}
	
	public float getUsuarioPromedioPuntaje() {
		return UsuarioPromedioPuntaje;
	}
	
	public void setUsuarioPromedioPuntaje(float usuarioPromedioPuntaje) {
		UsuarioPromedioPuntaje = usuarioPromedioPuntaje;
	}
	
	public int getUsuarioTelefono() {
		return UsuarioTelefono;
	}
	
	public void setUsuarioTelefono(int usuarioTelefono) {
		UsuarioTelefono = usuarioTelefono;
	}
	
	public List<DataInstanciaServicio> getInstanciasServicio() {
		return InstanciasServicio;
	}
	
	public void setInstanciasServicio(List<DataInstanciaServicio> instanciasServicio) {
		InstanciasServicio = instanciasServicio;
	}	
	
	public DataServicio getServicio() {
		return Servicio;
	}

	public void setServicio(DataServicio servicio) {
		Servicio = servicio;
	}

}