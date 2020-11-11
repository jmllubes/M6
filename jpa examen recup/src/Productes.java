
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Productes {

	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int id_producto;
	private String nom;
	private int preu;
	
	@ManyToOne	
	private Productes productes;
	
	public Productes(int id, String nom, int preu) {
		
		super();
		this.id_producto= id;
		this.nom = nom;
		this.preu = preu;
		
	}
	

	public Productes() {
		super();
	}


	public int getId() {
		return id_producto;
	}


	public void setId(int id_producto) {
		this.id_producto = id_producto;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getPreu() {
		return preu;
	}


	public void setPreu(int preu) {
		this.preu = preu;
	}
	
	public String toString() {
		return "Productes [id_producto=" + id_producto + ", nom =" + nom + ", preu=" + preu + "]";
	}
}
