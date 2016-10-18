package com.datatypes;

import java.util.List;


public class DataCliente {
	
	private String UsuarioCorreo;
	private String UsuarioNombre;
	private String UsuarioApellido;
	private String UsuarioCiudad;
	private String UsuarioContrase�a;
	private String UsuarioDireccion;	
	private float UsuarioPromedioPuntaje;
	private String UsuarioTelefono;
	private List<DataInstanciaServicioBasico> InstanciasServicio;
	
	public DataCliente() {
	}
	
	public DataCliente(String UsuarioCorreo, String UsuarioNombre, String UsuarioApellido, String UsuarioCiudad, String UsuarioContrase�a, String UsuarioDireccion, float UsuarioPromedioPuntaje, String UsuarioTelefono, List<DataInstanciaServicioBasico> InstanciasServicio) {
		this.UsuarioCorreo 			= UsuarioCorreo;
		this.UsuarioNombre 			= UsuarioNombre;
		this.UsuarioApellido		= UsuarioApellido;
		this.UsuarioCiudad			= UsuarioCiudad;
		this.UsuarioContrase�a		= UsuarioContrase�a;
		this.UsuarioDireccion		= UsuarioDireccion;
		this.UsuarioTelefono		= UsuarioTelefono;
		this.UsuarioPromedioPuntaje	= UsuarioPromedioPuntaje;
		this.InstanciasServicio		= InstanciasServicio;	
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
	
	public String getUsuarioContrase�a() {
		return UsuarioContrase�a;
	}
	
	public void setUsuarioContrase�a(String usuarioContrase�a) {
		UsuarioContrase�a = usuarioContrase�a;
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
	
	public String getUsuarioTelefono() {
		return UsuarioTelefono;
	}
	
	public void setUsuarioTelefono(String usuarioTelefono) {
		UsuarioTelefono = usuarioTelefono;
	}
	
	public List<DataInstanciaServicioBasico> getInstanciasServicio() {
		return InstanciasServicio;
	}
	
	public void setInstanciasServicio(List<DataInstanciaServicioBasico> instanciasServicio) {
		InstanciasServicio = instanciasServicio;
	}	

}
