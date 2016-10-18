import java.util.List;
import java.util.Scanner;

import com.controladores.ControladorAdministrador;
import com.controladores.ControladorCliente;
import com.controladores.ControladorProveedor;
import com.controladores.ControladorServicios;
import com.datatypes.DataCliente;
import com.datatypes.DataServicio;
import com.datatypes.DataUbicacion;
import com.entities.Cliente;
import com.entities.Usuario;

public class main {
	
	public static void main(String[] Args){
		ControladorCliente cc = new ControladorCliente();
		ControladorServicios cs = new ControladorServicios();
		
		DataCliente u = new DataCliente();	
		u.setUsuarioNombre("Martin");
		u.setUsuarioApellido("Perez");
		u.setUsuarioCiudad("San Jose");
		u.setUsuarioContraseña("pass");
		u.setUsuarioCorreo("user1@hotmail.com");
		u.setUsuarioDireccion("18 de julio 321");		
		u.setUsuarioPromedioPuntaje(0);
		u.setUsuarioTelefono("098826898");
		
		
		cc.ObtenerClientes();
		
		
		
	}
	
	
	
}
