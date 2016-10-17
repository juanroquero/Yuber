package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import com.datatypes.DataInstanciaServicio;
import com.datatypes.DataProveedor;
import com.datatypes.DataServicio;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Servicio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ServicioId;
	private String ServicioNombre;
	private float ServicioPrecioHora;
	private float ServicioPrecioKM;
	private float ServicioTarifaBase;
	@OneToMany(mappedBy="Servicio", cascade=CascadeType.PERSIST)
	private List<InstanciaServicio> InstanciasServicio;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Vertical Vertical;
	@OneToMany(mappedBy="Servicio", cascade=CascadeType.PERSIST)
	private List<Proveedor> Proveedores;

	public Servicio() {
	}
	
	public DataServicio getDataServicio(){
		List<DataInstanciaServicio> ListaInstanciasServicio = new ArrayList<DataInstanciaServicio>();
		for(InstanciaServicio Instancia : this.InstanciasServicio)
		{
			DataInstanciaServicio DataInstanciaServicio = Instancia.getDataInstanciaServicio();
			ListaInstanciasServicio.add(DataInstanciaServicio);
		}
		List<DataProveedor> ListaProveedores = new ArrayList<DataProveedor>();
		for(Proveedor Proveedor : this.Proveedores)
		{
			DataProveedor DataProveedor = Proveedor.getDataProveedor();
			ListaProveedores.add(DataProveedor);
		}		
		return new DataServicio(
								this.getServicioId(),
								this.getServicioNombre(),
								this.getServicioPrecioHora(),
								this.getServicioPrecioKM(),
								this.getServicioTarifaBase(),
								ListaInstanciasServicio,
								this.Vertical.getDataVertical(),
								ListaProveedores
							   );
	}

	public int getServicioId() {
		return this.ServicioId;
	}

	public void setServicioId(int ServicioId) {
		this.ServicioId = ServicioId;
	}

	public String getServicioNombre() {
		return this.ServicioNombre;
	}

	public void setServicioNombre(String ServicioNombre) {
		this.ServicioNombre = ServicioNombre;
	}

	public float getServicioPrecioHora() {
		return this.ServicioPrecioHora;
	}

	public void setServicioPrecioHora(float ServicioPrecioHora) {
		this.ServicioPrecioHora = ServicioPrecioHora;
	}

	public float getServicioPrecioKM() {
		return this.ServicioPrecioKM;
	}

	public void setServicioPrecioKM(float ServicioPrecioKM) {
		this.ServicioPrecioKM = ServicioPrecioKM;
	}

	public float getServicioTarifaBase() {
		return this.ServicioTarifaBase;
	}

	public void setServicioTarifaBase(float ServicioTarifaBase) {
		this.ServicioTarifaBase = ServicioTarifaBase;
	}

	public List<InstanciaServicio> getInstanciasServicio() {
		return this.InstanciasServicio;
	}

	public void setInstanciasServicio(List<InstanciaServicio> InstanciasServicio) {
		this.InstanciasServicio = InstanciasServicio;
	}

	public InstanciaServicio addInstanciaservicio(InstanciaServicio InstanciaServicio) {
		getInstanciasServicio().add(InstanciaServicio);
		InstanciaServicio.setServicio(this);
		return InstanciaServicio;
	}

	public InstanciaServicio removeInstanciaservicio(InstanciaServicio InstanciaServicio) {
		getInstanciasServicio().remove(InstanciaServicio);
		InstanciaServicio.setServicio(null);
		return InstanciaServicio;
	}

	public Vertical getVertical() {
		return this.Vertical;
	}

	public void setVertical(Vertical Vertical) {
		this.Vertical = Vertical;
	}

	public List<Proveedor> getProveedores() {
		return this.Proveedores;
	}

	public void setProveedores(List<Proveedor> Proveedores) {
		this.Proveedores = Proveedores;
	}

	public Proveedor addProveedor(Proveedor Proveedor) {
		getProveedores().add(Proveedor);
		Proveedor.setServicio(this);
		return Proveedor;
	}

	public Proveedor removeUsuario(Proveedor Proveedor) {
		getProveedores().remove(Proveedor);
		Proveedor.setServicio(null);
		return Proveedor;
	}

}