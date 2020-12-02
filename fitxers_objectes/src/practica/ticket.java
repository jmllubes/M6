package practica;

import java.io.Serializable;

public class ticket implements Serializable {

    private String nom_empleat;
    private int codi_ticket;
    private String data_ticket;
    private producte producte_ticket;

    public ticket(String nom_empleat, int codi_ticket, String data_ticket, producte producte_ticket) {
	super();
	this.nom_empleat = nom_empleat;
	this.codi_ticket = codi_ticket;
	this.data_ticket = data_ticket;
	this.producte_ticket = producte_ticket;
    }

    public ticket() {
    }

    public String getNom_empleat() {
	return nom_empleat;
    }

    public void setNom_empleat(String nom_empleat) {
	this.nom_empleat = nom_empleat;
    }

    public int getCodi_ticket() {
	return codi_ticket;
    }

    public void setCodi_ticket(int codi_ticket) {
	this.codi_ticket = codi_ticket;
    }

    public String getData_ticket() {
	return data_ticket;
    }

    public void setData_ticket(String data_ticket) {
	this.data_ticket = data_ticket;
    }

    public producte getProducte_ticket() {
	return producte_ticket;
    }

    public void setProducte_ticket(producte producte_ticket) {
	this.producte_ticket = producte_ticket;
    }

    @Override
    public String toString() {
	return "ticket [nom_empleat=" + nom_empleat + ", codi_ticket=" + codi_ticket + ", data_ticket=" + data_ticket
		+ ", producte_ticket=" + producte_ticket + "]";
    }

}
