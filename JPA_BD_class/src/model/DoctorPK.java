package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the doctor database table.
 * 
 */
@Embeddable
public class DoctorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="HOSPITAL_COD", insertable=false, updatable=false, unique=true, nullable=false)
	private byte hospitalCod;

	@Column(name="DOCTOR_NO", unique=true, nullable=false)
	private short doctorNo;

	public DoctorPK() {
	}
	public byte getHospitalCod() {
		return this.hospitalCod;
	}
	public void setHospitalCod(byte hospitalCod) {
		this.hospitalCod = hospitalCod;
	}
	public short getDoctorNo() {
		return this.doctorNo;
	}
	public void setDoctorNo(short doctorNo) {
		this.doctorNo = doctorNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DoctorPK)) {
			return false;
		}
		DoctorPK castOther = (DoctorPK)other;
		return 
			(this.hospitalCod == castOther.hospitalCod)
			&& (this.doctorNo == castOther.doctorNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.hospitalCod);
		hash = hash * prime + ((int) this.doctorNo);
		
		return hash;
	}
}