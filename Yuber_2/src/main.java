import java.util.List;

import com.controladores.ControladorAdministrador;
import com.controladores.ControladorProveedor;
import com.controladores.ControladorServicios;
import com.datatypes.DataAdministrador;
import com.datatypes.DataCliente;
import com.datatypes.DataProveedor;
import com.datatypes.DataServicio;
import com.datatypes.DataVertical;

public class main {

	public static void main(String[] Args){
		ControladorAdministrador CAdmin = new ControladorAdministrador();
		ControladorProveedor cp = new ControladorProveedor();
		ControladorServicios CServicios = new ControladorServicios();
	//	cp.ObtenerHistorial("user1@hotmail.com");	
		//cp.prueba();
		//cp.prueba();
	/*	List<DataProveedor> DPs = CAdmin.ObtenerProveedoresActivos();
		for (DataProveedor DP : DPs)
		{
			System.out.println("Proveedores: " +DP.getUsuarioNombre());
		}
		List<DataCliente> DCs = CAdmin.ObtenerClientesActivos();
		for (DataCliente DC : DCs)
		{
			System.out.println("Clientes: " + DC.getUsuarioNombre());
		}*/
		
		//DataAdministrador Administrador = CAdmin.ObtenerAdministrador("Admin@gmail.coom");
		//
		
	/*	CRUD ADMIN
		DataAdministrador Administrador = new DataAdministrador("Admin@gmail.com", "admin", "admin123", null);
		CAdmin.CrearAdministrador(Administrador);
		Administrador = CAdmin.ObtenerAdministrador("Admin@gmail.com");
		System.out.println("Admin: " + Administrador.getAdministradorNombre());
		Administrador = new DataAdministrador("Admin@gmail.com", "admincambiado", "admin123", null);
		CAdmin.ModificarAdministrador(Administrador);
		Administrador = CAdmin.ObtenerAdministrador("Admin@gmail.com");
		System.out.println("Admin2: " + Administrador.getAdministradorNombre());
		CAdmin.EliminarAdministrador("Admin@gmail.com");
		Administrador = CAdmin.ObtenerAdministrador("Admin@gmail.com");
		System.out.println("Admin2: " + Administrador.getAdministradorNombre());*/
		//DataVertical NuevaDataVertical = new DataVertical("Transporte", "Transporte", null, null);
		//CAdmin.CrearVertical(NuevaDataVertical);
		//DataServicio NuevoServicio = new DataServicio(0, "Taxi", 300, 15, 30, null , NuevaDataVertical , null);
		//CServicios.CrearServicio(NuevoServicio);
		
		List<DataServicio> Servicios = CServicios.ObtenerServicios("Transporte");
		for(DataServicio DS : Servicios)
		{
			System.out.println(DS.getServicioId() + " " + DS.getServicioNombre());
		}
		
		
	}
	
}
