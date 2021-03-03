package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the servicio database table.
 * 
 */
@Entity
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String hora;

	@Column(name="tipo_servicio")
	private String tipoServicio;

	private int urgencia;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="servicio")
	private List<Equipo> equipos;

	//bi-directional many-to-one association to Parque
	@ManyToOne
	private Parque parque;

	public Servicio() {
	}

	public int getId() {
		return this.id;
	}

	public Servicio(int id, Date fecha, String hora, String tipoServicio, int urgencia, Parque parque) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.tipoServicio = tipoServicio;
		this.urgencia = urgencia;
		this.parque = parque;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getTipoServicio() {
		return this.tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public int getUrgencia() {
		return this.urgencia;
	}

	public void setUrgencia(int urgencia) {
		this.urgencia = urgencia;
	}

	public List<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo addEquipo(Equipo equipo) {
		getEquipos().add(equipo);
		equipo.setServicio(this);

		return equipo;
	}

	public Equipo removeEquipo(Equipo equipo) {
		getEquipos().remove(equipo);
		equipo.setServicio(null);

		return equipo;
	}

	public Parque getParque() {
		return this.parque;
	}

	public void setParque(Parque parque) {
		this.parque = parque;
	}

	@Override
	public String toString() {
	    return "Servicio [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", tipoServicio=" + tipoServicio
		    + ", urgencia=" + urgencia + "]";
	}
	
	

}