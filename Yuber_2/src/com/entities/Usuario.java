package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import com.datatypes.DataInstanciaServicio;
import com.datatypes.DataUsuario;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String UsuarioCorreo;
	private String UsuarioNombre;
	private String UsuarioApellido;
	private String UsuarioCiudad;
	private String UsuarioContrase�a;
	private String UsuarioDireccion;	
	private float UsuarioPromedioPuntaje;
	private int UsuarioTelefono;	
	
	public Usuario() {
	}

	public DataUsuario getDataUsuario(){
		return new DataUsuario(	this.UsuarioCorreo, 
								this.UsuarioNombre, 
								this.UsuarioApellido, 
								this.UsuarioCiudad, 
								this.UsuarioContrase�a, 
								this.UsuarioDireccion, 
								this.UsuarioPromedioPuntaje, 
								this.UsuarioTelefono
							   );
	}
	
	public String getUsuarioCorreo() {
		return this.UsuarioCorreo;
	}

	public void setUsuarioCorreo(String UsuarioCorreo) {
		this.UsuarioCorreo = UsuarioCorreo;
	}

	public String getUsuarioApellido() {
		return this.UsuarioApellido;
	}

	public void setUsuarioApellido(String UsuarioApellido) {
		this.UsuarioApellido = UsuarioApellido;
	}

	public String getUsuarioCiudad() {
		return this.UsuarioCiudad;
	}

	public void setUsuarioCiudad(String UsuarioCiudad) {
		this.UsuarioCiudad = UsuarioCiudad;
	}

	public String getUsuarioContrase�a() {
		return this.UsuarioContrase�a;
	}

	public void setUsuarioContrase�a(String UsuarioContrase�a) {
		this.UsuarioContrase�a = UsuarioContrase�a;
	}

	public String getUsuarioDireccion() {
		return this.UsuarioDireccion;
	}

	public void setUsuarioDireccion(String UsuarioDireccion) {
		this.UsuarioDireccion = UsuarioDireccion;
	}

	public String getUsuarioNombre() {
		return this.UsuarioNombre;
	}

	public void setUsuarioNombre(String UsuarioNombre) {
		this.UsuarioNombre = UsuarioNombre;
	}

	public float getUsuarioPromedioPuntaje() {
		return this.UsuarioPromedioPuntaje;
	}

	public void setUsuarioPromedioPuntaje(float UsuarioPromedioPuntaje) {
		this.UsuarioPromedioPuntaje = UsuarioPromedioPuntaje;
	}

	public int getUsuarioTelefono() {
		return this.UsuarioTelefono;
	}

	public void setUsuarioTelefono(int UsuarioTelefono) {
		this.UsuarioTelefono = UsuarioTelefono;
	}

}