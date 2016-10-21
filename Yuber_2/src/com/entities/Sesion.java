package com.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

@Entity
@NamedQuery(query = "SELECT s FROM Sesion s WHERE s.CorreoUsuario = :CorreoUsuario", name = "EstaLogeado")
public class Sesion implements Serializable {

	@Id
	private int SesionId;
	private String SesionDeviceID;
	private String CorreoUsuario;
	private boolean SesionHabilitada;
	private Date Fecha;
	private static final long serialVersionUID = 1L;

	public Sesion() {
		super();
	}   
	public int getSesionId() {
		return this.SesionId;
	}

	public void setSesionId(int SesionId) {
		this.SesionId = SesionId;
	}   
	public String getSesionDeviceID() {
		return this.SesionDeviceID;
	}

	public void setSesionDeviceID(String SesionDeviceID) {
		this.SesionDeviceID = SesionDeviceID;
	}   
	public String getCorreoUsuario() {
		return this.CorreoUsuario;
	}

	public void setCorreoUsuario(String CorreoUsuario) {
		this.CorreoUsuario = CorreoUsuario;
	}   
	public boolean getSesionHabilitada() {
		return this.SesionHabilitada;
	}

	public void setSesionHabilitada(boolean SesionHabilitada) {
		this.SesionHabilitada = SesionHabilitada;
	}   
	public Date getFecha() {
		return this.Fecha;
	}

	public void setFecha(Date Fecha) {
		this.Fecha = Fecha;
	}
   
}
