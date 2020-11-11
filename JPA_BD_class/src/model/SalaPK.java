package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sala database table.
 * 
 */
@Embeddable
public class SalaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="HOSPITAL_COD", insertable=false, updatable=false, unique=true, nullable=false)
	private byte hospitalCod;

	@Column(name="SALA_COD", unique=true, nullable=false)
	private byte salaCod;

	public SalaPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SalaPK)) {
			return false;
		}
		SalaPK castOther = (SalaPK)other;
		return 
			(this.hospitalCod == castOther.hospitalCod)
			&& (this.salaCod == castOther.salaCod);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.hospitalCod);
		hash = hash * prime + ((int) this.salaCod);
		
		return hash;
	}
}