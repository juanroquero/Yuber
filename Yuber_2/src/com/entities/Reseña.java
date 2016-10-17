package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.datatypes.DataReseña;

@Entity
public class Reseña implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ReseñaId;
	@OneToOne(cascade=CascadeType.PERSIST)
	private InstanciaServicio InstanciaServicio;
	private String ReseñaComentario;
	private int ReseñaPuntaje;

	public Reseña() {
	}
	
	public DataReseña getDataReseña(){
		return new DataReseña(
							this.ReseñaId,
							this.InstanciaServicio.getDataInstanciaServicio(),
							this.ReseñaComentario,
							this.ReseñaPuntaje
						 	);
	}

	public int getReseñaId() {
		return this.ReseñaId;
	}

	public void setReseñaId(int ReseñaId) {
		this.ReseñaId = ReseñaId;
	}

	public InstanciaServicio getInstanciaServicio() {
		return InstanciaServicio;
	}

	public void setInstanciaServicio(InstanciaServicio instanciaServicio) {
		InstanciaServicio = instanciaServicio;
	}

	public String getReseñaComentario() {
		return ReseñaComentario;
	}

	public void setReseñaComentario(String reseñaComentario) {
		ReseñaComentario = reseñaComentario;
	}

	public int getReseñaPuntaje() {
		return ReseñaPuntaje;
	}

	public void setReseñaPuntaje(int reseñaPuntaje) {
		ReseñaPuntaje = reseñaPuntaje;
	}
		
}