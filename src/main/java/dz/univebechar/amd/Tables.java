package dz.univebechar.amd;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="tables")
public class Tables {
	@Id
     private int id;
     private String name;
     private String status;
     private float prix;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
}
