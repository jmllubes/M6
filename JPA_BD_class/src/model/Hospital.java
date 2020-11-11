package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hospital database table.
 * 
 */
@Entity
@Table(name="hospital")
@NamedQuery(name="Hospital.findAll", query="SELECT h FROM Hospital h")
public class Hospital implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="HOSPITAL_COD", unique=true, nullable=false)
	private byte hospitalCod;

	@Column(length=20)
	private String adreca;

	@Column(nullable=false, length=10)
	private String nom;

	@Column(name="QTAT_LLITS")
	private int qtatLlits;

	@Column(length=8)
	private String telefon;

	//bi-directional many-to-one association to Doctor
	@OneToMany(mappedBy="hospital")
	private List<Doctor> doctors;

	//bi-directional many-to-one association to Sala
	@OneToMany(mappedBy="hospital")
	private List<Sala> salas;

	public Hospital() {
	}

	public byte getHospitalCod() {
		return this.hospitalCod;
	}

	public void setHospitalCod(byte hospitalCod) {
		this.hospitalCod = hospitalCod;
	}

	public String getAdreca() {
		return this.adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
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

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public List<Doctor> getDoctors() {
		return this.doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Doctor addDoctor(Doctor doctor) {
		getDoctors().add(doctor);
		doctor.setHospital(this);

		return doctor;
	}

	public Doctor removeDoctor(Doctor doctor) {
		getDoctors().remove(doctor);
		doctor.setHospital(null);

		return doctor;
	}

	public List<Sala> getSalas() {
		return this.salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	public Sala addSala(Sala sala) {
		getSalas().add(sala);
		sala.setHospital(this);

		return sala;
	}

	public Sala removeSala(Sala sala) {
		getSalas().remove(sala);
		sala.setHospital(null);

		return sala;
	}

}