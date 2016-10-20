import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.controladores.ControladorAdministrador;
import com.controladores.ControladorCliente;
import com.controladores.ControladorProveedor;
import com.controladores.ControladorServicios;
import com.datatypes.DataAdministrador;
import com.datatypes.DataCliente;
import com.datatypes.DataClienteBasico;
import com.datatypes.DataProveedor;
import com.datatypes.DataProveedorBasico;
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
		
		//*********************** CONTROLADOR CLIENTE ***********************//
			//REGISTRO CLIENTE
			
			/*DataCliente Cliente = new DataCliente("user1@hotmail.com", "nombre1", "apellido1", "San Jose", "123", "18 de julio 123", 0, "094568452", null);  
			cc.RegistrarCliente(Cliente);*/
				
			//OBTENER CLIENTES
			/*
			List<DataCliente> lista = cc.ObtenerClientes();
			for(DataCliente du : lista){
				System.out.println(du.getUsuarioCorreo());
			}
			*/
			
		/*DataUbicacion DataUbicacion = new DataUbicacion("85258","150651");
			System.out.println(cc.PedirServicio("user1@hotmail.com", 1, DataUbicacion));*/
			
		//System.out.println(cc.CancelarPedido(101));
			
		//System.out.println(cc.PuntuarCliente(5, "Un rompe huevos el tipo", 51));

			
		//	cp.IniciarServicio(351);
		
		//	cp.FinServicio(351, 256, 12, 126);
		//*********************** CONTROLADOR PROVEEDOR **********************//
			//REGISTRO PROVEEDOR
			
		/*	DataProveedor Proveedor = new DataProveedor("prov2@hotmail.com", "nombre2", "apellido2", "Montevideo", "123", "18 de julio 123", 0, "092569751",false, null, null);  
			cp.RegistrarProveedor(Proveedor);*/
		
		
		//System.out.println(cp.IniciarJornada("prov2@hotmail.com", 1));
		
		//System.out.println(cp.FinalizarJornada("prov2@hotmail.com", 1));
			
		//cp.AsociarServicio("prov2@hotmail.com", 1);
		
		//System.out.println(cp.AceptarServicio(51, "prov2@hotmail.com"));
		
		//System.out.println(cp.IniciarServicio(51));
		
		//System.out.println(cp.FinServicio(51,568,5,25));
		
		//System.out.println(cp.PuntuarProveedor(10, "Lindo viaje", 51));
		
		
		/*
			Date fecha = new Date();
			System.out.println(ca.ObtenerGananciaMensual(fecha));
	*/
		/*
			List<DataProveedorBasico> lista = ca.TopProveedoresPorGanancia(1);
			for(DataProveedorBasico dpb : lista){
				System.out.println(dpb.getUsuarioCorreo());
			}*/

	/*	List<DataClienteBasico> lista = ca.TopClientesPorCantServicios(1);
		for(DataClienteBasico dpb : lista){
			System.out.println(dpb.getUsuarioCorreo());
		}*/
	
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
			
			/*DataVerticalBasico dv = new DataVerticalBasico("transporte", "Vertical transporte");
			ca.CrearVertical(dv);*/
			
			//OBTENER PROVEEDORES ACTIVOS
			/*
			List<DataProveedorBasico> lista = ca.ObtenerProveedoresActivos();
			for(DataProveedorBasico dt : lista){
				System.out.println(dt.getUsuarioNombre());
			}
			System.out.println("jojo");
			List<DataClienteBasico> lista2 = ca.ObtenerClientesActivos();
			for(DataClienteBasico dt : lista2){
				System.out.println(dt.getUsuarioNombre());
			}
			*/
			
			
			
		//*********************** CONTROLADOR SERVICIO ***********************//
			//CREAR SERVICIO
		/*	DataServicioBasico Servicio = new DataServicioBasico(0, "taxi", 50, 20, 50, 0);
			System.out.println(cs.CrearServicio(Servicio, "transporte"));
		*/
			//OBTENER SERVICIOS
			/*
			List<DataServicio> lista = cs.ObtenerServicios("Transporte");
			for(DataServicio dt : lista){
				System.out.println(dt.getServicioNombre());
			}
			*/
		 	//MODIFICAR DATOS DE SERVICIO
			/*
			DataServicioBasico Servicio = new DataServicioBasico(101, "MecanicA", 100, 100, 100,1);
			System.out.println(cs.ModificarServicio(Servicio));
			*/
			
			/* System.out.println(cs.ObtenerServicio(101).getEstado()); */
			
			
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