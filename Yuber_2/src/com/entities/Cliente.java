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
	
	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
	}
		
    public DataCliente getDataCliente(){		
		List<DataInstanciaServicio> ListaInstancias = new ArrayList<DataInstanciaServicio>();
		for(InstanciaServicio Instancia : this.getInstanciasServicio())
		{
			DataInstanciaServicio DataInstanciaServicio = Instancia.getDataInstanciaServicio();
			ListaInstancias.add(DataInstanciaServicio);
		}		
		return new DataCliente(	this.getUsuarioCorreo(), 
								this.getUsuarioNombre(), 
								this.getUsuarioApellido(), 
								this.getUsuarioCiudad(), 
								this.getUsuarioContraseņa(), 
								this.getUsuarioDireccion(), 
								this.getUsuarioPromedioPuntaje(), 
								this.getUsuarioTelefono(), 
								ListaInstancias
							   );
	}
    
    
   
}
