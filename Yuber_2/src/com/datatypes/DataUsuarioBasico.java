package com.datatypes;


public class DataUsuarioBasico {
	
	private String Estado = "Ok";
	private String UsuarioCorreo;
	private String UsuarioNombre;
	private String UsuarioApellido;
	private String UsuarioCiudad;
	private String UsuarioContraseņa;
	private String UsuarioDireccion;	
	private float UsuarioPromedioPuntaje;
	private String UsuarioTelefono;
	
	public DataUsuarioBasico() {
	}
	
	public DataUsuarioBasico(String usuarioCorreo, String usuarioNombre, String usuarioApellido, String usuarioCiudad,
		String usuarioContraseņa, String usuarioDireccion, float usuarioPromedioPuntaje, String usuarioTelefono) {
		super();
		UsuarioCorreo = usuarioCorreo;
		UsuarioNombre = usuarioNombre;
		UsuarioApellido = usuarioApellido;
		UsuarioCiudad = usuarioCiudad;
		UsuarioContraseņa = usuarioContraseņa;
		UsuarioDireccion = usuarioDireccion;
		UsuarioPromedioPuntaje = usuarioPromedioPuntaje;
		UsuarioTelefono = usuarioTelefono;
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

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}
	
}
