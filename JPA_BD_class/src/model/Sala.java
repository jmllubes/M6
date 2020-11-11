package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sala database table.
 * 
 */
@Entity
@Table(name="sala")
@NamedQuery(name="Sala.findAll", query="SELECT s FROM Sala s")
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SalaPK id;

	@Column(nullable=false, length=20)
	private String nom;

	@Column(name="QTAT_LLITS")
	private int qtatLlits;

	//bi-directional many-to-one association to Ingresso
	@OneToMany(mappedBy="sala")
	private List<Ingresso> ingressos;

	//bi-directional many-to-one association to Plantilla
	@OneToMany(mappedBy="sala")
	private List<Plantilla> plantillas;

	//bi-directional many-to-one association to Hospital
	@ManyToOne
	@JoinColumn(name="HOSPITAL_COD", nullable=false, insertable=false, updatable=false)
	private Hospital hospital;

	public Sala() {
	}

	public SalaPK getId() {
		return this.id;
	}

	public void setId(SalaPK id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQtatLlits() {
		return this.qtatLlits;
	}

	public void setQtatLlits(int qtatLlits) {
		this.qtatLlits = qtatLlits;
	}

	public List<Ingresso> getIngressos() {
		return this.ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	public Ingresso addIngresso(Ingresso ingresso) {
		getIngressos().add(ingresso);
		ingresso.setSala(this);

		return ingresso;
	}

	public Ingresso removeIngresso(Ingresso ingresso) {
		getIngressos().remove(ingresso);
		ingresso.setSala(null);

		return ingresso;
	}

	public List<Plantilla> getPlantillas() {
		return this.plantillas;
	}

	public void setPlantillas(List<Plantilla> plantillas) {
		this.plantillas = plantillas;
	}

	public Plantilla addPlantilla(Plantilla plantilla) {
		getPlantillas().add(plantilla);
		plantilla.setSala(this);

		return plantilla;
	}

	public Plantilla removePlantilla(Plantilla plantilla) {
		getPlantillas().remove(plantilla);
		plantilla.setSala(null);

		return plantilla;
	}

	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

}