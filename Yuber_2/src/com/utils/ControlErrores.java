package com.utils;

public class ControlErrores {

	public String Ok = "Ok";
	
	//Errores genericos
	public String G1 = "Se produjo un error, vuelva a intentar";
	
	//A0-A100 : Errores de Administradores
	public String A50 = "El administrador actual no tiene permisos suficientes para asignar dicha vertical";
	public String A51 = "El administrador actual no tiene permisos suficientes para denegar dicha vertical";
	public String A52 = "El administrador no existe en el sistema";
	public String A53 = "El administrador ya existe en el sistema";
	public String A54 = "No se ha podido desasociar el administrador";
	
	//C0-100 : Errores de Clientes
	public String C52 = "El cliente no existe en el sistema";
	public String C53 = "Error calculando el puntaje del cliente";
	
	//P0-P100 : Errores de Provedores
	public String P50 = "El proveedor no brinda el servicio dado";
	public String P51 = "El proveedor debe estar trabajando";
	public String P52 = "El proveedor no existe en el sistema";
	public String P53 = "Error calculando el puntaje del proveedor";
		
	//I0-I100 : Errores de Instancias de servicio
	public String I50 = "La servicio ya fue asignada a otro proveedor";
	public String I52 = "La servicio no existe en el sistema";
	public String I53 = "El servicio ya fue finalizado";
		
	//S0-S100 : Errores de Servicios
	public String S1 = "No existe dicha vertical";
	public String S2 = "No existe dicho servicio";
	
	//V0-V100 : Errores de Verticales
	public String V50 = "La vertical ya existe en el sistema";
	public String V51 = "La vertical no existe en el sistema";
	public String V52 = "No se ha podido desasociar la vertical";
	
	//L0-L100 : Errores de Sesiones
	public String L1 = "La sesion no existe en el sistema";
	public String L2 = "La vertical no existe en el sistema";
		
	public ControlErrores() {
		
	}
	
}
