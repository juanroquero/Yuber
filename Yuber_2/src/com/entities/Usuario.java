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
	private String UsuarioContraseña;
	private String UsuarioDireccion;	
	private float UsuarioPromedioPuntaje;
	private int UsuarioTelefono;
	@OneToMany(mappedBy="Usuario", cascade=CascadeType.PERSIST)
	private List<InstanciaServicio> InstanciasServicio;
	
	public Usuario() {
	}

	public DataUsuario getDataUsuario(){		
		List<DataInstanciaServicio> ListaInstancias = new ArrayList<DataInstanciaServicio>();
		for(InstanciaServicio Instancia : this.getInstanciasServicio())
		{
			DataInstanciaServicio DataInstanciaServicio = Instancia.getDataInstanciaServicio();
			ListaInstancias.add(DataInstanciaServicio);
		}		
		return new DataUsuario(	this.UsuarioCorreo, 
								this.UsuarioNombre, 
								this.UsuarioApellido, 
								this.UsuarioCiudad, 
								this.UsuarioContraseña, 
								this.UsuarioDireccion, 
								this.UsuarioPromedioPuntaje, 
								this.UsuarioTelefono, 
								ListaInstancias
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

	public String getUsuarioContraseña() {
		return this.UsuarioContraseña;
	}

	public void setUsuarioContraseña(String UsuarioContraseña) {
		this.UsuarioContraseña = UsuarioContraseña;
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

	public List<InstanciaServicio> getInstanciasServicio() {
		return this.InstanciasServicio;
	}

	public void setInstanciasServicio(List<InstanciaServicio> instanciaServicios) {
		this.InstanciasServicio = instanciaServicios;
	}

	public InstanciaServicio addInstanciaServicio(InstanciaServicio instanciaServicio) {
		getInstanciasServicio().add(instanciaServicio);
		instanciaServicio.setUsuario(this);
		return instanciaServicio;
	}

	public InstanciaServicio removeInstanciaServicio(InstanciaServicio instanciaServicio) {
		getInstanciasServicio().remove(instanciaServicio);
		instanciaServicio.setUsuario(null);
		return instanciaServicio;
	}

}