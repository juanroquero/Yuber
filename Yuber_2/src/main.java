import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.controladores.ControladorAdministrador;
import com.controladores.ControladorCliente;
import com.controladores.ControladorProveedor;
import com.controladores.ControladorServicios;
import com.datatypes.DataAdministrador;
import com.datatypes.DataCliente;
import com.datatypes.DataProveedor;
import com.datatypes.DataServicio;
import com.datatypes.DataServicioBasico;
import com.datatypes.DataVertical;
import com.datatypes.DataVerticalBasico;
import com.datatypes.DataUbicacion;
import com.datatypes.DataUsuario;
import com.entities.Cliente;
import com.entities.Usuario;
import com.utils.ControlErrores;

public class main {
	
	public static void main(String[] Args){
		ControladorCliente cc = new ControladorCliente();
		ControladorProveedor cp = new ControladorProveedor();
		ControladorServicios cs = new ControladorServicios();
		ControladorAdministrador ca = new ControladorAdministrador();
		ControlErrores CE = new ControlErrores();
		
		//*********************** CONTROLADOR CLIENTE ***********************//
			//REGISTRO CLIENTE
			/*
			DataCliente Cliente = new DataCliente("user2@hotmail.com", "nombre2", "apellido2", "San Jose", "123", "18 de julio 123", 0, "094568452", null);  
			cc.RegistrarCliente(Cliente);
			*/		
			//OBTENER CLIENTES
			/*
			List<DataCliente> lista = cc.ObtenerClientes();
			for(DataCliente du : lista){
				System.out.println(du.getUsuarioCorreo());
			}
			*/
		
		
		
		
		//*********************** CONTROLADOR PROVEEDOR **********************//
			//REGISTRO CLIENTE
			/*
			DataProveedor Proveedor = new DataProveedor("prov1@hotmail.com", "nombre1", "apellido1", "Montevideo", "123", "18 de julio 123", 0, "092569751", null, null);  
			cp.RegistrarProveedor(Proveedor);
			*/
			
			
	
			//********************* CONTROLADOR ADMINISTRADOR ********************//
			//REGISTRO ADMINISTRADOR
			/*
			DataAdministrador da = new DataAdministrador("admin2@hotmail.com", "admin3", "123", null);
			System.out.print(ca.CrearAdministrador(da));
			*/
			
			//ELIMINAR ADMINISTRADOR
			/*
			ca.EliminarAdministrador("admin2@hotmail.com");
			*/
			
			//MODIFICAR ADMINISTRADOR
			/*
			DataAdministrador Administrador = new DataAdministrador("admin1@hotmail.com", "juan", "256", null);
			System.out.print(ca.ModificarAdministrador(Administrador));
			*/
			
			/*
			DataVerticalBasico dvb = new DataVerticalBasico("Transporte","Vertical demanda");
			List<DataVerticalBasico> listadvb = new ArrayList<DataVerticalBasico>();
			listadvb.add(dvb);
			DataAdministrador Administrador = new DataAdministrador("admin1@hotmail.com", "Maxi", "256", listadvb);
			System.out.print(ca.ModificarAdministrador(Administrador));
			*/
					
			//CREAR VERTICAL
			/*
			DataVertical dv = new DataVertical("Transporte","Vertical transporte", null, null);
			ca.CrearVertical(dv);*/
			
			
		//*********************** CONTROLADOR SERVICIO ***********************//
			//CREAR SERVICIO
			/*
			DataVerticalBasico Vertical = new DataVerticalBasico("On-Site", "transporte!");
			DataServicio Servicio = new DataServicio(0, "Mecanico", 50, 20, 50, null, Vertical, null);
			cs.CrearServicio(Servicio);
			*/
			//OBTENER SERVICIOS
			/*
			List<DataServicio> lista = cs.ObtenerServicios("Transporte");
			for(DataServicio dt : lista){
				System.out.println(dt.getServicioNombre());
			}
			*/
		 	//MODIFICAR DATOS DE SERVICIO
		/*	DataVerticalBasico Vertical = new DataVerticalBasico("On-Site", "transporte!");
			DataServicioBasico Servicio = new DataServicioBasico(301, "Mecanico", 100, 100, 100);
			cs.ModificarServicio(Servicio);
			*/
		
			//Asignar Vertical admin2 - Transporte			
	 	    /* 
		    String Result = ca.AsignarVertical("FullAccess", "admin2@hotmail.com", "Transporte");
		    System.out.println(Result);
		    */
		
			//Revocar Vertical admin2 - Transporte			
	 	   /* 
		    String Result = ca.DenegarVertical("FullAccess", "admin2@hotmail.com", "Transporte");
		    System.out.println(Result);
		    */
	}
	
	
	
}