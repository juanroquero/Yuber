package com.webservices;

import java.util.Date;
import java.util.List;

import com.datatypes.DataAdministrador;
import com.datatypes.DataAdministradorBasico;
import com.datatypes.DataClienteBasico;
import com.datatypes.DataProveedorBasico;
import com.datatypes.DataVerticalBasico;

public interface ControladorAdministradorWS {

	void Login(String AdministradorEmail, String Password);

	List<DataClienteBasico> ObtenerClientesActivos();

	List<DataProveedorBasico> ObtenerProveedoresActivos();

	String CrearAdministrador(DataAdministradorBasico Administrador);

	String EliminarAdministrador(String AdministradorEmail);

	String ModificarAdministrador(DataAdministradorBasico Administrador);

	DataAdministrador ObtenerAdministrador(String AdministradorEmail);

	float ObtenerGananciaMensual(Date fecha);

	List<DataProveedorBasico> TopProveedoresPorPuntajes(int Limit);

	List<DataProveedorBasico> TopProveedoresPorGanancia(int Limit);

	List<DataClienteBasico> TopClientesPorPuntaje(int Limit);

	String CrearVertical(DataVerticalBasico Vertical);

	String AsignarVertical(String AdminCreadorId, String AdminId, String TipoVertical);

	String DenegarVertical(String AdminCreadorId, String AdminId, String TipoVertical);

}