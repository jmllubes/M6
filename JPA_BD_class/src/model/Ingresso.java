package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the ingressos database table.
 * 
 */
@Entity
@Table(name="ingressos")
@NamedQuery(name="Ingresso.findAll", query="SELECT i FROM Ingresso i")
public class Ingresso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int inscripcio;

	private int llit;

	@Column(nullable=false)
	private Time temps;

	//bi-directional one-to-one association to Malalt
	@OneToOne
	@JoinColumn(name="INSCRIPCIO", nullable=false, insertable=false, updatable=false)
	private Malalt malalt;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="HOSPITAL_COD", referencedColumnName="HOSPITAL_COD", nullable=false),
		@JoinColumn(name="SALA_COD", referencedColumnName="SALA_COD", nullable=false)
		})
	private Sala sala;

	public Ingresso() {
	}

	public int getInscripcio() {
		return this.inscripcio;
	}

	public void setInscripcio(int inscripcio) {
		this.inscripcio = inscripcio;
	}

	public int getLlit() {
		return this.llit;
	}

	public void setLlit(int llit) {
		this.llit = llit;
	}

	public Time getTemps() {
		return this.temps;
	}

	public void setTemps(Time temps) {
		this.temps = temps;
	}

	public Malalt getMalalt() {
		return this.malalt;
	}

	public void setMalalt(Malalt malalt) {
		this.malalt = malalt;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

}