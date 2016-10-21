package com.webservices;

import java.util.List;

import com.datatypes.DataServicio;
import com.datatypes.DataServicioBasico;

public interface ControladorServiciosWS {

	List<DataServicio> ObtenerServicios(String TipoDeVertical);

	String CrearServicio(DataServicioBasico Servicio, String TipoVertical);

	String EliminarServicio(int ServicioId);

	String ModificarServicio(DataServicioBasico Servicio);

	DataServicio ObtenerServicio(int ServicioId);

}