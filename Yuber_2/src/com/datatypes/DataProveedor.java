package com.datatypes;

import java.util.List;

public class DataProveedor {
	
	private String Estado = "Ok";
	private String UsuarioCorreo;
	private String UsuarioNombre;
	private String UsuarioApellido;
	private String UsuarioCiudad;
	private String UsuarioContraseņa;
	private String UsuarioDireccion;	
	private float UsuarioPromedioPuntaje;
	private String UsuarioTelefono;
	private boolean Trabajando;
	private List<DataInstanciaServicioBasico> InstanciasServicio;
	private DataServicioBasico Servicio;
	
	public DataProveedor() {
	}
	
	public DataProveedor(String UsuarioCorreo, String UsuarioNombre, String UsuarioApellido, String UsuarioCiudad, String UsuarioContraseņa, String UsuarioDireccion, float UsuarioPromedioPuntaje, String UsuarioTelefono, boolean Trabajando, List<DataInstanciaServicioBasico> InstanciasServicio, DataServicioBasico Servicio) {
		this.UsuarioCorreo 			= UsuarioCorreo;
		this.UsuarioNombre 			= UsuarioNombre;
		this.UsuarioApellido		= UsuarioApellido;
		this.UsuarioCiudad			= UsuarioCiudad;
		this.UsuarioContraseņa		= UsuarioContraseņa;
		this.UsuarioDireccion		= UsuarioDireccion;
		this.UsuarioTelefono		= UsuarioTelefono;
		this.UsuarioPromedioPuntaje	= UsuarioPromedioPuntaje;
		this.Trabajando				= Trabajando;
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
	
	public String getUsuarioContraseņa() {
		return UsuarioContraseņa;
	}
	
	public void setUsuarioContraseņa(String usuarioContraseņa) {
		UsuarioContraseņa = usuarioContraseņa;
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
	
	public DataServicioBasico getServicio() {
		return Servicio;
	}

	public void setServicio(DataServicioBasico servicio) {
		Servicio = servicio;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public boolean isTrabajando() {
		return Trabajando;
	}

	public void setTrabajando(boolean trabajando) {
		Trabajando = trabajando;
	}

}