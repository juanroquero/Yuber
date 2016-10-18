package com.entities;

import java.io.Serializable;
import java.util.Date;

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
	private Date InstanciaServicioFechaInicio;
	private Date InstanciaServicioFechaFin;
	private float InstanciaServicioTiempo;
	private String Latitud;
	private String Longitud;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Reseña ReseñaCliente;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Reseña ReseñaProveedor;	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Servicio Servicio;
	@ManyToOne
	private Cliente Cliente;
	@ManyToOne
	private Proveedor Proveedor;
	
	public InstanciaServicio() {
	}
	
	public DataInstanciaServicio getDataInstanciaServicio() {
		DataUbicacion DataUbicacion = new DataUbicacion(Longitud,Latitud);
		return new DataInstanciaServicio(	this.InstanciaServicioId,
											this.InstanciaServicioCosto,
											this.InstanciaServicioDistancia,
											this.InstanciaServicioFechaInicio,
											this.InstanciaServicioFechaFin,
											this.InstanciaServicioTiempo,
											DataUbicacion,
											this.ReseñaCliente.getDataReseña(),
											this.ReseñaProveedor.getDataReseña(),
											this.Servicio.getDataServicio(),
											this.Cliente.getDataCliente(),
											this.Proveedor.getDataProveedor()
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

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}

	public Proveedor getProveedor() {
		return Proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		Proveedor = proveedor;
	}

	public Date getInstanciaServicioFechaInicio() {
		return InstanciaServicioFechaInicio;
	}

	public void setInstanciaServicioFechaInicio(Date instanciaServicioFechaInicio) {
		InstanciaServicioFechaInicio = instanciaServicioFechaInicio;
	}

	public Date getInstanciaServicioFechaFin() {
		return InstanciaServicioFechaFin;
	}

	public void setInstanciaServicioFechaFin(Date instanciaServicioFechaFin) {
		InstanciaServicioFechaFin = instanciaServicioFechaFin;
	}	
	
}