package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import com.datatypes.*;

@Entity
public class InstanciaServicio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int InstanciaServicioId;
	private float InstanciaServicioCosto;
	private float InstanciaServicioDistancia;
	private String InstanciaServicioFecha;
	private float InstanciaServicioTiempo;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Rese�a Rese�aCliente;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Rese�a Rese�aProveedor;	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Servicio Servicio;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Usuario Usuario;

	public InstanciaServicio() {
	}
	
	public DataInstanciaServicio getDataInstanciaServicio() {
		return new DataInstanciaServicio(	this.getInstanciaServicioId(),
											this.getInstanciaServicioCosto(),
											this.getInstanciaServicioDistancia(),
											this.getInstanciaServicioFecha(),
											this.getInstanciaServicioTiempo(),
											this.Rese�aCliente.getDataRese�a(),
											this.Rese�aProveedor.getDataRese�a(),
											this.Servicio.getDataServicio(),
											this.Usuario.getDataUsuario() 
										);
	}

	public int getInstanciaServicioId() {
		return this.InstanciaServicioId;
	}

	public void setInstanciaServicioId(int InstanciaServicioId) {
		this.InstanciaServicioId = InstanciaServicioId;
	}

	public float getInstanciaServicioCosto() {
		return this.InstanciaServicioCosto;
	}

	public void setInstanciaServicioCosto(float InstanciaServicioCosto) {
		this.InstanciaServicioCosto = InstanciaServicioCosto;
	}

	public float getInstanciaServicioDistancia() {
		return this.InstanciaServicioDistancia;
	}

	public void setInstanciaServicioDistancia(float InstanciaServicioDistancia) {
		this.InstanciaServicioDistancia = InstanciaServicioDistancia;
	}

	public String getInstanciaServicioFecha() {
		return this.InstanciaServicioFecha;
	}

	public void setInstanciaServicioFecha(String InstanciaServicioFecha) {
		this.InstanciaServicioFecha = InstanciaServicioFecha;
	}

	public float getInstanciaServicioTiempo() {
		return this.InstanciaServicioTiempo;
	}

	public void setInstanciaServicioTiempo(float InstanciaServicioTiempo) {
		this.InstanciaServicioTiempo = InstanciaServicioTiempo;
	}

	public Servicio getServicio() {
		return this.Servicio;
	}

	public void setServicio(Servicio servicio) {
		this.Servicio = servicio;
	}

	public Usuario getUsuario() {
		return this.Usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.Usuario = usuario;
	}

	public Rese�a getRese�aCliente() {
		return Rese�aCliente;
	}

	public void setRese�aCliente(Rese�a rese�aCliente) {
		Rese�aCliente = rese�aCliente;
	}

	public Rese�a getRese�aProveedor() {
		return Rese�aProveedor;
	}

	public void setRese�aProveedor(Rese�a rese�aProveedor) {
		Rese�aProveedor = rese�aProveedor;
	}	
	
}