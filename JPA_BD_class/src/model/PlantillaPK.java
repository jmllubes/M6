package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the plantilla database table.
 * 
 */
@Embeddable
public class PlantillaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="HOSPITAL_COD", insertable=false, updatable=false, unique=true, nullable=false)
	private byte hospitalCod;

	@Column(name="SALA_COD", insertable=false, updatable=false, unique=true, nullable=false)
	private byte salaCod;

	@Column(name="EMPLEAT_NO", unique=true, nullable=false)
	private short empleatNo;

	public PlantillaPK() {
	}
	public byte getHospitalCod() {
		return this.hospitalCod;
	}
	public void setHospitalCod(byte hospitalCod) {
		this.hospitalCod = hospitalCod;
	}
	public byte getSalaCod() {
		return this.salaCod;
	}
	public void setSalaCod(byte salaCod) {
		this.salaCod = salaCod;
	}
	public short getEmpleatNo() {
		return this.empleatNo;
	}
	public void setEmpleatNo(short empleatNo) {
		this.empleatNo = empleatNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PlantillaPK)) {
			return false;
		}
		PlantillaPK castOther = (PlantillaPK)other;
		return 
			(this.hospitalCod == castOther.hospitalCod)
			&& (this.salaCod == castOther.salaCod)
			&& (this.empleatNo == castOther.empleatNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.hospitalCod);
		hash = hash * prime + ((int) this.salaCod);
		hash = hash * prime + ((int) this.empleatNo);
		
		return hash;
	}
}