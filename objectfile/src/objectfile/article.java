package objectfile;

import java.io.Serializable;

public class article implements Serializable {

    private String ID;
    private String nom;
    private String categoria;
    private String preu;
    
    public article() {
	
    }
    
    public article(String iD, String nom, String categoria, String preu) {
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

    public void setPreu(String preu2) {
        this.preu = preu2;
    }

    @Override
    public String toString() {
	return "article [ID=" + ID + ", nom=" + nom + ", categoria=" + categoria + ", preu=" + preu + "]";
    }
    
    
}
