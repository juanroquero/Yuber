package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.datatypes.DataReseņa;
import com.datatypes.DataReseņaBasico;

@Entity
public class Reseņa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ReseņaId;
	@OneToOne(cascade=CascadeType.PERSIST)
	private InstanciaServicio InstanciaServicio;
	private String ReseņaComentario;
	private int ReseņaPuntaje;

	public Reseņa() {
	}
	
	public DataReseņa getDataReseņa(){
		return new DataReseņa(
							this.ReseņaId,
							this.InstanciaServicio.getDataInstanciaServicioBasico(),
							this.ReseņaComentario,
							this.ReseņaPuntaje
						 	);
	}
	
	public DataReseņaBasico getDataReseņaBasico(){
		return new DataReseņaBasico(
							this.ReseņaId,
							this.ReseņaComentario,
							this.ReseņaPuntaje
						 	);
	}

	public int getReseņaId() {
		return this.ReseņaId;
	}

	public void setReseņaId(int ReseņaId) {
		this.ReseņaId = ReseņaId;
	}

	public InstanciaServicio getInstanciaServicio() {
		return InstanciaServicio;
	}

	public void setInstanciaServicio(InstanciaServicio instanciaServicio) {
		InstanciaServicio = instanciaServicio;
	}

	public String getReseņaComentario() {
		return ReseņaComentario;
	}

	public void setReseņaComentario(String reseņaComentario) {
		ReseņaComentario = reseņaComentario;
	}

	public int getReseņaPuntaje() {
		return ReseņaPuntaje;
	}

	public void setReseņaPuntaje(int reseņaPuntaje) {
		ReseņaPuntaje = reseņaPuntaje;
	}
		
}