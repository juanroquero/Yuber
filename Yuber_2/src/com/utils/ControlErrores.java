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
	
	//P0-P100 : Errores de Provedores
	
	//S0-S100 : Errores de Servicios
	public String S1 = "No existe dicha vertical";
	public String S2 = "No existe dicho servicio";
	
	//V0-V100 : Errores de Verticales
	public String V50 = "La vertical ya existe en el sistema";
	public String V51 = "La vertical no existe en el sistema";
	public String V52 = "No se ha podido desasociar la vertical";
	
	
	
	
	
	public ControlErrores() {
		
	}
	
	
	

}
