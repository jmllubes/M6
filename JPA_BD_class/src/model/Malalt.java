package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the malalt database table.
 * 
 */
@Entity
@Table(name="malalt")
@NamedQuery(name="Malalt.findAll", query="SELECT m FROM Malalt m")
public class Malalt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int inscripcio;

	@Column(length=20)
	private String adreca;

	@Column(nullable=false, length=15)
	private String cognom;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_NAIX")
	private Date dataNaix;

	@Column(length=9)
	private String nss;

	@Column(nullable=false, length=1)
	private String sexe;

	@Column(nullable=false)
	private Time temps;

	//bi-directional one-to-one association to Ingresso
	@OneToOne(mappedBy="malalt")
	private Ingresso ingresso;

	public Malalt() {
	}

	public int getInscripcio() {
		return this.inscripcio;
	}

	public void setInscripcio(int inscripcio) {
		this.inscripcio = inscripcio;
	}

	public String getAdreca() {
		return this.adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	public String getCognom() {
		return this.cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public Date getDataNaix() {
		return this.dataNaix;
	}

	public void setDataNaix(Date dataNaix) {
		this.dataNaix = dataNaix;
	}

	public String getNss() {
		return this.nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Time getTemps() {
		return this.temps;
	}

	public void setTemps(Time temps) {
		this.temps = temps;
	}

	public Ingresso getIngresso() {
		return this.ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}

}