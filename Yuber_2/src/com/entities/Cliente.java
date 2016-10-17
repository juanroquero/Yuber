package com.entities;

import com.datatypes.DataCliente;
import com.datatypes.DataInstanciaServicio;
import com.entities.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Cliente extends Usuario implements Serializable {
	
	@OneToMany(mappedBy="Cliente", cascade=CascadeType.PERSIST)
	private List<InstanciaServicio> InstanciasServicio;
	
	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
	}
		
    public DataCliente getDataCliente(){		
		List<DataInstanciaServicio> ListaInstancias = new ArrayList<DataInstanciaServicio>();
		for(InstanciaServicio Instancia : InstanciasServicio)
		{
			DataInstanciaServicio DataInstanciaServicio = Instancia.getDataInstanciaServicio();
			ListaInstancias.add(DataInstanciaServicio);
		}		
		return new DataCliente(	this.getUsuarioCorreo(), 
								this.getUsuarioNombre(), 
								this.getUsuarioApellido(), 
								this.getUsuarioCiudad(), 
								this.getUsuarioContrase�a(), 
								this.getUsuarioDireccion(), 
								this.getUsuarioPromedioPuntaje(), 
								this.getUsuarioTelefono(), 
								ListaInstancias
							   );
	}
    
    public InstanciaServicio addInstanciaServicio(InstanciaServicio instanciaServicio) {
		getInstanciasServicio().add(instanciaServicio);
		instanciaServicio.setCliente(this);
		return instanciaServicio;
	}

	public InstanciaServicio removeInstanciaServicio(InstanciaServicio instanciaServicio) {
		getInstanciasServicio().remove(instanciaServicio);
		instanciaServicio.setCliente(null);
		return instanciaServicio;
	}
    
	public List<InstanciaServicio> getInstanciasServicio() {
		return this.InstanciasServicio;
	}

	public void setInstanciasServicio(List<InstanciaServicio> instanciaServicios) {
		this.InstanciasServicio = instanciaServicios;
	}
   
}
