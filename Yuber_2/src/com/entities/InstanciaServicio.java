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
	private Reseña ReseñaCliente;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Reseña ReseñaProveedor;	
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
											this.ReseñaCliente.getDataReseña(),
											this.ReseñaProveedor.getDataReseña(),
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

	public Reseña getReseñaCliente() {
		return ReseñaCliente;
	}

	public void setReseñaCliente(Reseña reseñaCliente) {
		ReseñaCliente = reseñaCliente;
	}

	public Reseña getReseñaProveedor() {
		return ReseñaProveedor;
	}

	public void setReseñaProveedor(Reseña reseñaProveedor) {
		ReseñaProveedor = reseñaProveedor;
	}	
	
}