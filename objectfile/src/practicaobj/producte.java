package practicaobj;

import java.io.Serializable;

public class producte implements Serializable{
    
    private String ID;
    private String nom;
    private String categoria;
    private String preu;
    
    
    
    public producte(String iD, String nom, String categoria, String preu) {
	super();
	ID = iD;
	this.nom = nom;
	this.categoria = categoria;
	this.preu = preu;
    }
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getPreu() {
        return preu;
    }
    public void setPreu(String preu) {
        this.preu = preu;
    }
    @Override
    public String toString() {
	return "producte [ID=" + ID + ", nom=" + nom + ", categoria=" + categoria + ", preu=" + preu + "]";
    }
    
    
    

}
