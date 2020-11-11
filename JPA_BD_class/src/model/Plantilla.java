package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the plantilla database table.
 * 
 */
@Entity
@Table(name="plantilla")
@NamedQuery(name="Plantilla.findAll", query="SELECT p FROM Plantilla p")
public class Plantilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PlantillaPK id;

	@Column(nullable=false, length=15)
	private String cognom;

	@Column(length=10)
	private String funcio;

	private int salari;

	@Column(length=1)
	private String torn;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="HOSPITAL_COD", referencedColumnName="HOSPITAL_COD", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="SALA_COD", referencedColumnName="SALA_COD", nullable=false, insertable=false, updatable=false)
		})
	private Sala sala;

	public Plantilla() {
	}

	public PlantillaPK getId() {
		return this.id;
	}

	public void setId(PlantillaPK id) {
		this.id = id;
	}

	public String getCognom() {
		return this.cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public String getFuncio() {
		return this.funcio;
	}

	public void setFuncio(String funcio) {
		this.funcio = funcio;
	}

	public int getSalari() {
		return this.salari;
	}

	public void setSalari(int salari) {
		this.salari = salari;
	}

	public String getTorn() {
		return this.torn;
	}

	public void setTorn(String torn) {
		this.torn = torn;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

}