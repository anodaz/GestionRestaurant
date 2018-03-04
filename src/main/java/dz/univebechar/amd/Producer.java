package dz.univebechar.amd;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="producer")
public class Producer {
	@Id
     private int id_p;
     private String name;
     private String Definition;
     private float prix;
	public int getId() {
		return id_p;
	}
	public void setId(int id_p) {
		this.id_p = id_p;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDefinition() {
		return Definition;
	}
	public void setDefinition(String definition) {
		Definition = definition;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
}
