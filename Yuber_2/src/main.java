import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import com.controladores.ControladorAdministrador;
import com.controladores.ControladorCliente;
import com.controladores.ControladorProveedor;
import com.controladores.ControladorServicios;
import com.datatypes.DataAdministrador;
import com.datatypes.DataAdministradorBasico;
import com.datatypes.DataCliente;
import com.datatypes.DataClienteBasico;
import com.datatypes.DataInstanciaServicio;
import com.datatypes.DataProveedor;
import com.datatypes.DataProveedorBasico;
import com.datatypes.DataReseña;
import com.datatypes.DataServicio;
import com.datatypes.DataServicioBasico;
import com.datatypes.DataVertical;
import com.datatypes.DataVerticalBasico;
import com.datatypes.DataUbicacion;
import com.datatypes.DataUsuario;
import com.entities.Cliente;
import com.entities.Reseña;
import com.entities.Usuario;
import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;
import com.utils.ControlErrores;

public class main {
	
	
	
	public static void main(String[] Args){
		ControladorCliente cc = new ControladorCliente();
		ControladorProveedor cp = new ControladorProveedor();
		ControladorServicios cs = new ControladorServicios();
		ControladorAdministrador ca = new ControladorAdministrador();
		//*********************** CARGA INICIAL ***********************//
	/*	//-->Agrego usuarios
		DataCliente Cliente = new DataCliente("user1@hotmail.com", "NombreUser1", "ApellidoUser1", "San Jose", "pass123", "18 de julio 123", 0, "094568451", null);  
		cc.RegistrarCliente(Cliente);
		Cliente = new DataCliente("user2@hotmail.com", "NombreUser2", "ApellidoUser2", "San Jose", "pass123", "18 de julio 321", 0, "094568452", null);  
		cc.RegistrarCliente(Cliente);
		Cliente = new DataCliente("user3@hotmail.com", "NombreUser3", "ApellidoUser3", "San Jose", "pass123", "18 de julio 213", 0, "094568453", null);  
		cc.RegistrarCliente(Cliente);
		Cliente = new DataCliente("user4@hotmail.com", "NombreUser4", "ApellidoUser4", "San Jose", "pass123", "18 de julio 231", 0, "094568454", null);  
		cc.RegistrarCliente(Cliente);
		Cliente = new DataCliente("user5@hotmail.com", "NombreUser5", "ApellidoUser5", "San Jose", "pass123", "18 de julio 432", 0, "094568455", null);  
		cc.RegistrarCliente(Cliente);
		//-->Agrego Provedores
		DataProveedor Proveedor = Proveedor = new DataProveedor("prov1@hotmail.com", "NombreProv1", "ApellidoProv1", "Montevideo", "pass123", "18 de julio 123", 0, "092569751",false, null, null);  
		cp.RegistrarProveedor(Proveedor);
		Proveedor = new DataProveedor("prov2@hotmail.com", "NombreProv2", "ApellidoProv2", "Montevideo", "pass123", "18 de julio 123", 0, "092569752",false, null, null);  
		cp.RegistrarProveedor(Proveedor);
		Proveedor = new DataProveedor("prov3@hotmail.com", "NombreProv3", "ApellidoProv3", "Montevideo", "pass123", "18 de julio 123", 0, "092569753",false, null, null);  
		cp.RegistrarProveedor(Proveedor);		
		//-->Agrego Administradores
		DataAdministradorBasico da = new DataAdministradorBasico("admin1@hotmail.com", "admin1", "pass123");
		System.out.println("Crea administrador: "+ca.CrearAdministrador(da));
		da = new DataAdministradorBasico("admin2@hotmail.com", "admin2", "pass123");
		System.out.println("Crea administrador: "+ca.CrearAdministrador(da));
		da = new DataAdministradorBasico("admin3@hotmail.com", "admin2", "pass123");
		System.out.println("Crea administrador: "+ca.CrearAdministrador(da));
		//-->Creo verticales		
		DataVerticalBasico dvb = new DataVerticalBasico("Transporte", "Vertical de transporte");
		System.out.println("Crea vertical: "+ca.CrearVertical(dvb));
		dvb = new DataVerticalBasico("On-Site", "Vertical on-site");
		System.out.println("Crea vertical: "+ca.CrearVertical(dvb));
		//-->Asigno administradoes a verticales
		System.out.println("Asigna vertical a administrador: "+ca.AsignarVertical("FullAccess", "admin1@hotmail.com", "Transporte"));
		System.out.println("Asigna vertical a administrador: "+ca.AsignarVertical("FullAccess", "admin1@hotmail.com", "On-Site"));
		System.out.println("Asigna vertical a administrador: "+ca.AsignarVertical("FullAccess", "admin2@hotmail.com", "Transporte"));
		System.out.println("Asigna vertical a administrador: "+ca.AsignarVertical("FullAccess", "admin3@hotmail.com", "On-Site"));
		DataServicioBasico Servicio = new DataServicioBasico(0, "Taxi", 50, 50, 50, 0);
		System.out.println("Crea servicio: "+cs.CrearServicio(Servicio, "Transporte"));
		Servicio = new DataServicioBasico(0, "Dron", 50, 50, 50, 0);
		System.out.println("Crea servicio: "+cs.CrearServicio(Servicio, "Transporte"));
		Servicio = new DataServicioBasico(0, "A caballito", 50, 50, 50, 0);
		System.out.println("Crea servicio: "+cs.CrearServicio(Servicio, "Transporte"));		
		System.out.println("Crea servicio: "+cs.CrearServicio(Servicio, "On-Site"));
		Servicio = new DataServicioBasico(0, "Carpintero", 50, 50, 50, 0);
		System.out.println("Crea servicio: "+cs.CrearServicio(Servicio, "On-Site"));
		Servicio = new DataServicioBasico(0, "Cocinero", 50, 50, 50, 0);
		System.out.println("Crea servicio: "+cs.CrearServicio(Servicio, "On-Site"));
		Servicio = new DataServicioBasico(0, "Plomero", 50, 50, 50, 0);
		//-->Iniciar jornada
		DataServicio ds;
		List<DataServicio> ListaServicio = cs.ObtenerServicios("Transporte");
		Iterator<DataServicio> iter = ListaServicio.iterator();
		ds = iter.next();	
		System.out.println("Asocia servico a proveedor: "+cp.AsociarServicio("prov1@hotmail.com", ds.getServicioId()));
		System.out.println("Inicia jornada proveedor: "+cp.IniciarJornada("prov1@hotmail.com", ds.getServicioId()));
		ds = iter.next();	
		System.out.println("Asocia servico a proveedor: "+cp.AsociarServicio("prov2@hotmail.com", ds.getServicioId()));
		System.out.println("Inicia jornada proveedor: "+cp.IniciarJornada("prov2@hotmail.com", ds.getServicioId()));
		ds = iter.next();	
		System.out.println("Asocia servico a proveedor: "+cp.AsociarServicio("prov3@hotmail.com", ds.getServicioId()));
		System.out.println("Inicia jornada proveedor: "+cp.IniciarJornada("prov3@hotmail.com", ds.getServicioId()));
		//-->Creo instancias servicios
		List<DataServicio> ListaServicios =  cs.ObtenerServicios("Transporte");		
		DataUbicacion Dataubicacion;
		//servicio 1
		iter = ListaServicios.iterator();
		ds = iter.next();	    
		Dataubicacion = new DataUbicacion("85258","150651");		
		int idis = cc.PedirServicio("user1@hotmail.com", ds.getServicioId(), Dataubicacion);
		System.out.println("Id del servicio pedido: "+idis);
		System.out.println("Aceptar servicio: "+cp.AceptarServicio(idis, "prov1@hotmail.com"));
		System.out.println("Iniciar viaje: "+cp.IniciarServicio(idis));		
		System.out.println("Fin servicio: "+cp.FinServicio(idis, 126));		
		System.out.println("Puntua el proveedor: "+cc.PuntuarCliente(3, "No me agrado el auto, pero bien", idis));
		System.out.println("Puntua el cliente: "+cp.PuntuarProveedor(5, "Todo bien", idis));
		idis = cc.PedirServicio("user2@hotmail.com", ds.getServicioId(), Dataubicacion);
		System.out.println("Id del servicio pedido: "+idis);
		System.out.println("Aceptar servicio: "+cp.AceptarServicio(idis, "prov2@hotmail.com"));
		System.out.println("Iniciar viaje: "+cp.IniciarServicio(idis));	
		System.out.println("Fin servicio: "+cp.FinServicio(idis, 126));	
		System.out.println("Puntua el proveedor: "+cc.PuntuarCliente(5, "La musica encaro pila", idis));
		System.out.println("Puntua el cliente: "+cp.PuntuarProveedor(4, "Hablaba hasta por los codos pero bien", idis));
		//servicio 2
		iter = ListaServicios.iterator();
		ds = iter.next();	    
		Dataubicacion = new DataUbicacion("85258","150651");
		idis = cc.PedirServicio("user3@hotmail.com", ds.getServicioId(), Dataubicacion);
		System.out.println("Id del servicio pedido: "+idis);
		System.out.println("Aceptar servicio: "+cp.AceptarServicio(idis, "prov3@hotmail.com"));
		System.out.println("Iniciar viaje: "+cp.IniciarServicio(idis));	
		System.out.println("Fin servicio: "+cp.FinServicio(idis,126));
		System.out.println("Puntua el proveedor: "+cc.PuntuarCliente(1, "Choco", idis));
		System.out.println("Puntua el cliente: "+cp.PuntuarProveedor(3, "El loco bien, yo como el culo, chocamos!", idis));
		//servicio 3
		iter = ListaServicios.iterator();
		ds = iter.next();	    
		Dataubicacion = new DataUbicacion("85258","150651");
		idis = cc.PedirServicio("user1@hotmail.com", ds.getServicioId(), Dataubicacion);
		System.out.println("Id del servicio pedido: "+idis);
		System.out.println("Aceptar servicio: "+cp.AceptarServicio(idis, "prov3@hotmail.com"));
		System.out.println("Iniciar viaje: "+cp.IniciarServicio(idis));	
		System.out.println("Fin servicio: "+cp.FinServicio(idis,126));
		System.out.println("Puntua el proveedor: "+cc.PuntuarCliente(4, "Todo lo mas bien", idis));
		System.out.println("Puntua el cliente: "+cp.PuntuarProveedor(3, "Simpatica la mina", idis));
		idis = cc.PedirServicio("user4@hotmail.com", ds.getServicioId(), Dataubicacion);
		System.out.println("Id del servicio pedido: "+idis);
		System.out.println("Aceptar servicio: "+cp.AceptarServicio(idis, "prov1@hotmail.com"));
		System.out.println("Iniciar viaje: "+cp.IniciarServicio(idis));	
		System.out.println("Fin servicio: "+cp.FinServicio(idis, 126));
		System.out.println("Puntua el proveedor: "+cc.PuntuarCliente(5, "Encara el loco", idis));
		System.out.println("Puntua el cliente: "+cp.PuntuarProveedor(3, "Muitu good", idis));
		//servicio 4
		iter = ListaServicios.iterator();
		ds = iter.next();	    
		Dataubicacion = new DataUbicacion("85258","150651");
		idis = cc.PedirServicio("user5@hotmail.com", ds.getServicioId(), Dataubicacion);	
		System.out.println("Id del servicio pedido: "+idis);
		System.out.println("Aceptar servicio: "+cp.AceptarServicio(idis, "prov2@hotmail.com"));
		System.out.println("Iniciar viaje: "+cp.IniciarServicio(idis));	
		System.out.println("Fin servicio: "+cp.FinServicio(idis, 126));
		System.out.println("Puntua el proveedor: "+cc.PuntuarCliente(3, "Mas o menos", idis));
		System.out.println("Puntua el cliente: "+cp.PuntuarProveedor(2, "Cara de nabo", idis));
		idis = cc.PedirServicio("user4@hotmail.com", ds.getServicioId(), Dataubicacion);
		System.out.println("Id del servicio pedido: "+idis);
		System.out.println("Aceptar servicio: "+cp.AceptarServicio(idis, "prov3@hotmail.com"));
		System.out.println("Iniciar viaje: "+cp.IniciarServicio(idis));	
		System.out.println("Fin servicio: "+cp.FinServicio(idis, 126));
		System.out.println("Puntua el proveedor: "+cc.PuntuarCliente(1, "Un rompe huevos el tipo", idis));
		System.out.println("Puntua el cliente: "+cp.PuntuarProveedor(3, "No hablo en todo el camino", idis));
	*/	
		

		
		

	}
	
	
	
}