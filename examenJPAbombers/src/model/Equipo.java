package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the equipo database table.
 * 
 */
@Entity
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EquipoPK id;

	private String puesto;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	private Servicio servicio;

	//bi-directional many-to-one association to Bombero
	@ManyToOne
	private Bombero bombero;

	public Equipo() {
	}
	
	

	public Equipo(EquipoPK id, String puesto, Servicio servicio) {
	    super();
	    this.id = id;
	    this.puesto = puesto;
	    this.servicio = servicio;
	}



	public EquipoPK getId() {
		return this.id;
	}

	public void setId(EquipoPK id) {
		this.id = id;
	}

	public String getPuesto() {
		return this.puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Bombero getBombero() {
		return this.bombero;
	}

	public void setBombero(Bombero bombero) {
		this.bombero = bombero;
	}



	@Override
	public String toString() {
	    return "Equipo [id=" + id + ", puesto=" + puesto + "]";
	}
	

}