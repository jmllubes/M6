package practica;

import java.io.Serializable;

public class producte implements Serializable{

    private String nom;
    private int codi;
    private double preu;
    
    public producte() {}
    
    public producte(String nom, int codi, double preu) {
	super();
	this.nom = nom;
	this.codi = codi;
	this.preu = preu;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getCodi() {
        return codi;
    }
    public void setCodi(int codi) {
        this.codi = codi;
    }
    public double getPreu() {
        return preu;
    }
    public void setPreu(double preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
	return "producte [nom=" + nom + ", codi=" + codi + ", preu=" + preu + " € ]";
    }
    
    
}
