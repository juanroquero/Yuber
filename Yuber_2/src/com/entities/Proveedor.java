package com.entities;

import com.datatypes.DataInstanciaServicio;
import com.datatypes.DataProveedor;
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
   
	public Proveedor (DataProveedor Proveedor){
		Usuario user = new Proveedor();	
		user.setUsuarioNombre(Proveedor.getUsuarioNombre());
		user.setUsuarioApellido(Proveedor.getUsuarioApellido());
		user.setUsuarioCiudad(Proveedor.getUsuarioCiudad());
		user.setUsuarioContraseņa(Proveedor.getUsuarioContraseņa());
		user.setUsuarioCorreo(Proveedor.getUsuarioCorreo());
		user.setUsuarioDireccion(Proveedor.getUsuarioDireccion());		
		user.setUsuarioPromedioPuntaje(0);
		user.setUsuarioTelefono(Proveedor.getUsuarioTelefono());		
	}
	
	public DataProveedor getDataProveedor(){		
		List<DataInstanciaServicio> ListaInstancias = new ArrayList<DataInstanciaServicio>();
		for(InstanciaServicio Instancia : this.getInstanciasServicio())
		{
			DataInstanciaServicio DataInstanciaServicio = Instancia.getDataInstanciaServicio();
			ListaInstancias.add(DataInstanciaServicio);
		}	
		return new DataProveedor(
								this.getUsuarioCorreo(), 
								this.getUsuarioNombre(), 
								this.getUsuarioApellido(), 
								this.getUsuarioCiudad(), 
								this.getUsuarioContraseņa(), 
								this.getUsuarioDireccion(), 
								this.getUsuarioPromedioPuntaje(), 
								this.getUsuarioTelefono(), 
								ListaInstancias,
								this.Servicio.getDataServicio()
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
