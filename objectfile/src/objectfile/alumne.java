package objectfile;

import java.io.Serializable;

public class alumne implements Serializable{

    private String DNI;
    private String nom;
    private int edat;
    private int telefon;
    
    

	public alumne() {
    	
	}

	public alumne(String dNI, String nom, int edat, int telefon) {
		super();
		DNI = dNI;
		this.nom = nom;
		this.edat = edat;
		this.telefon = telefon;
	}
    
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getEdat() {
		return edat;
	}
	public void setEdat(int edat) {
		this.edat = edat;
	}
	public int getTelefon() {
		return telefon;
	}
	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}
	
	@Override
	public String toString() {
		return "alumne [ DNI=" + DNI + ", nom=" + nom + ", edat=" + edat + ", telefon=" + telefon + "]";
	}
    
}
