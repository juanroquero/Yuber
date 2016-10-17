package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.datatypes.DataAdministrador;
import com.datatypes.DataServicio;
import com.datatypes.DataVertical;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Vertical implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String VerticalTipo;
	private String VerticalNombre;
	@OneToMany(mappedBy="Vertical", cascade=CascadeType.PERSIST)
	private List<Servicio> Servicios;
	@ManyToMany(cascade=CascadeType.PERSIST)
	private List<Administrador> Administradores;

	public Vertical() {
	}
	
	public DataVertical getDataVertical(){		
		List<DataServicio> ListaServicios = new ArrayList<DataServicio>();
		for(Servicio Servicio : this.Servicios)
		{
			DataServicio DataServicio = Servicio.getDataServicio();
			ListaServicios.add(DataServicio);
		}		
		List<DataAdministrador> ListaAdministradores = new ArrayList<DataAdministrador>();
		for(Administrador Administrador : this.Administradores)
		{
			DataAdministrador DataAdministrador = Administrador.getDataAdministrador();
			ListaAdministradores.add(DataAdministrador);
		}		
		return new DataVertical(
								this.VerticalTipo, 
								this.VerticalNombre, 
								ListaServicios, 
								ListaAdministradores
							   );
	}

	public String getVerticalTipo() {
		return this.VerticalTipo;
	}

	public void setVerticalTipo(String VerticalTipo) {
		this.VerticalTipo = VerticalTipo;
	}

	public String getVerticalNombre() {
		return this.VerticalNombre;
	}

	public void setVerticalNombre(String VerticalNombre) {
		this.VerticalNombre = VerticalNombre;
	}

	public List<Servicio> getServicios() {
		return this.Servicios;
	}

	public void setServicios(List<Servicio> Servicios) {
		this.Servicios = Servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setVertical(this);
		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setVertical(null);
		return servicio;
	}

	public List<Administrador> getAdministradores() {
		return this.Administradores;
	}

	public void setAdministradores(List<Administrador> Administradores) {
		this.Administradores = Administradores;
	}

}