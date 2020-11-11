package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the doctor database table.
 * 
 */
@Entity
@Table(name="doctor")
@NamedQuery(name="Doctor.findAll", query="SELECT d FROM Doctor d")
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DoctorPK id;

	@Column(nullable=false, length=13)
	private String cognom;

	@Column(nullable=false, length=16)
	private String especialitat;

	//bi-directional many-to-one association to Hospital
	@ManyToOne
	@JoinColumn(name="HOSPITAL_COD", nullable=false, insertable=false, updatable=false)
	private Hospital hospital;

	public Doctor() {
	}

	public DoctorPK getId() {
		return this.id;
	}

	public void setId(DoctorPK id) {
		this.id = id;
	}

	public String getCognom() {
		return this.cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public String getEspecialitat() {
		return this.especialitat;
	}

	public void setEspecialitat(String especialitat) {
		this.especialitat = especialitat;
	}

	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

}