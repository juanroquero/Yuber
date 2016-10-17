package com.datatypes;

import java.util.List;

public class DataUsuario {
	
	private String UsuarioCorreo;
	private String UsuarioNombre;
	private String UsuarioApellido;
	private String UsuarioCiudad;
	private String UsuarioContraseņa;
	private String UsuarioDireccion;	
	private float UsuarioPromedioPuntaje;
	private int UsuarioTelefono;
	private List<DataInstanciaServicio> InstanciasServicio;
	
	public DataUsuario() {
	}
	
	public DataUsuario(String usuarioCorreo, String usuarioNombre, String usuarioApellido, String usuarioCiudad,
		String usuarioContraseņa, String usuarioDireccion, float usuarioPromedioPuntaje, int usuarioTelefono,
		List<DataInstanciaServicio> instanciasServicio) {
		super();
		UsuarioCorreo = usuarioCorreo;
		UsuarioNombre = usuarioNombre;
		UsuarioApellido = usuarioApellido;
		UsuarioCiudad = usuarioCiudad;
		UsuarioContraseņa = usuarioContraseņa;
		UsuarioDireccion = usuarioDireccion;
		UsuarioPromedioPuntaje = usuarioPromedioPuntaje;
		UsuarioTelefono = usuarioTelefono;
		InstanciasServicio = instanciasServicio;
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

}
