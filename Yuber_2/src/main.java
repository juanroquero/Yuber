import com.controladores.ControladorAdministrador;
import com.controladores.ControladorProveedor;

public class main {

	public static void main(String[] Args){
		ControladorProveedor cp = new ControladorProveedor();
	//	cp.ObtenerHistorial("user1@hotmail.com");	
		cp.OlvidePass("user1@hotmail.com");
		//cp.prueba();
	}
	
}
