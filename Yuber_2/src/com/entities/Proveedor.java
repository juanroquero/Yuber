package com.entities;

import com.datatypes.DataInstanciaServicioBasico;
import com.datatypes.DataProveedor;
import com.datatypes.DataProveedorBasico;
import com.datatypes.DataServicioBasico;
import com.entities.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Proveedor extends Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Servicio Servicio;
	@OneToMany(mappedBy="Proveedor", cascade=CascadeType.PERSIST)
	private List<InstanciaServicio> InstanciasServicio;

	public Proveedor() {
		super();
	}
   
	public DataProveedor getDataProveedor(){		
		List<DataInstanciaServicioBasico> ListaInstancias = new ArrayList<DataInstanciaServicioBasico>();
		for(InstanciaServicio Instancia : this.getInstanciasServicio())
		{
			DataInstanciaServicioBasico DataInstanciaServicio = Instancia.getDataInstanciaServicioBasico();
			ListaInstancias.add(DataInstanciaServicio);
		}	
		DataServicioBasico DataServicio;
		if (this.Servicio == null)
			DataServicio = null;
		else
			DataServicio = this.Servicio.getDataServicioBasico();
		return new DataProveedor(
								this.getUsuarioCorreo(), 
								this.getUsuarioNombre(), 
								this.getUsuarioApellido(), 
								this.getUsuarioCiudad(), 
								this.getUsuarioContraseña(), 
								this.getUsuarioDireccion(), 
								this.getUsuarioPromedioPuntaje(), 
								this.getUsuarioTelefono(), 
								ListaInstancias,
								DataServicio
							   );
	}
	
	public DataProveedorBasico getDataProveedorBasico(){		
		return new DataProveedorBasico(
								this.getUsuarioCorreo(), 
								this.getUsuarioNombre(), 
								this.getUsuarioApellido(), 
								this.getUsuarioCiudad(), 
								this.getUsuarioContraseña(), 
								this.getUsuarioDireccion(), 
								this.getUsuarioPromedioPuntaje(), 
								this.getUsuarioTelefono()
							   );
	}
	
	public Servicio getServicio() {
		return this.Servicio;
	}

	public void setServicio(Servicio Servicio) {
		this.Servicio = Servicio;
	}
	
	public List<InstanciaServicio> getInstanciasServicio() {
		return this.InstanciasServicio;
	}

	public void setInstanciasServicio(List<InstanciaServicio> instanciaServicios) {
		this.InstanciasServicio = instanciaServicios;
	}

	public InstanciaServicio addInstanciaServicio(InstanciaServicio instanciaServicio) {
		getInstanciasServicio().add(instanciaServicio);
		instanciaServicio.setProveedor(this);
		return instanciaServicio;
	}

	public InstanciaServicio removeInstanciaServicio(InstanciaServicio instanciaServicio) {
		getInstanciasServicio().remove(instanciaServicio);
		instanciaServicio.setProveedor(null);
		return instanciaServicio;
	}
	
}
