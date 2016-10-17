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

	public Proveedor() {
		super();
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
	
}
