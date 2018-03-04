package dz.univebechar.amd;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="admin")
public class Admin {
	@Id
     private int id;
     private String user;
     private String pass;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
