
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class Comandes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	private String data_comanda;
	private String id_comanda;
	

	@ManyToOne	
	private Clients clients;

	
	
	public Comandes(int id,  String data_comanda,String id_comanda) {
		
		super();
		this.id= id;
		this.data_comanda = data_comanda;
		this.id_comanda = id_comanda;
	}
	

	public Comandes() {
		super();
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	


	public String getData_comanda() {
		return data_comanda;
	}


	public void setData_comanda(String string) {
		this.data_comanda = string;
	}


	public String id_comanda() {
		return id_comanda;
	}

	public String toString() {
		return "Comandes [id=" + id  + ", data_comanda=" + data_comanda + "]";
	}
}


