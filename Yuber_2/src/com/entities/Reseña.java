package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.datatypes.DataRese�a;

@Entity
public class Rese�a implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Rese�aId;
	@OneToOne(cascade=CascadeType.PERSIST)
	private InstanciaServicio InstanciaServicio;
	private String Rese�aComentario;
	private int Rese�aPuntaje;

	public Rese�a() {
	}
	
	public DataRese�a getDataRese�a(){
		return new DataRese�a(
							this.Rese�aId,
							this.InstanciaServicio.getDataInstanciaServicio(),
							this.Rese�aComentario,
							this.Rese�aPuntaje
						 	);
	}

	public int getRese�aId() {
		return this.Rese�aId;
	}

	public void setRese�aId(int Rese�aId) {
		this.Rese�aId = Rese�aId;
	}

	public InstanciaServicio getInstanciaServicio() {
		return InstanciaServicio;
	}

	public void setInstanciaServicio(InstanciaServicio instanciaServicio) {
		InstanciaServicio = instanciaServicio;
	}

	public String getRese�aComentario() {
		return Rese�aComentario;
	}

	public void setRese�aComentario(String rese�aComentario) {
		Rese�aComentario = rese�aComentario;
	}

	public int getRese�aPuntaje() {
		return Rese�aPuntaje;
	}

	public void setRese�aPuntaje(int rese�aPuntaje) {
		Rese�aPuntaje = rese�aPuntaje;
	}
		
}