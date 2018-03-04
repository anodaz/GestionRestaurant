package dz.univebechar.amd;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("Admin")
public class ViewAdmin {
	@Autowired
	AdminRepo repo;
	Admin err=new Admin();
	
	@PostMapping(path = "Login", consumes = "application/xml", produces = "application/xml")
	public Admin loginAdmin(@RequestBody Admin a){
		//List<Admin> admin=(List<Admin>) repo.findAll();*
		err.setId(0);
		err.setPass("error");
		err.setUser("error");
		MessageDigest m;
		try {
			String normlPass=a.getPass();
			m = MessageDigest.getInstance("MD5");
			 m.reset();
			   m.update(normlPass.getBytes());
			   byte[] digest = m.digest();
			   BigInteger bigInt = new BigInteger(1,digest);
			   String hashtext = bigInt.toString(16);
			   Admin ch=repo.Check(a.getUser(), hashtext);
			   if(ch != null) {
				   return a;
			   }
				else
					return err;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return err;
		}
		  
		
	}
	@PostMapping(path = "Changepass/{oldpass}", consumes = "application/json", produces = "application/json")
	public Admin changepass(@RequestBody Admin a,@PathVariable  String oldpass){
		//List<Admin> admin=(List<Admin>) repo.findAll();*
		err.setId(0);
		err.setPass("error");
		err.setUser("error");
		MessageDigest m;
		MessageDigest s;
		try {
			String normlPass=a.getPass();
			m = MessageDigest.getInstance("MD5");
			 m.reset();
			   m.update(oldpass.getBytes());
			   byte[] digest = m.digest();
			   BigInteger bigInt = new BigInteger(1,digest);
			   String hashtext = bigInt.toString(16);
				s = MessageDigest.getInstance("MD5");
				s.reset();
				   s.update(normlPass.getBytes());
				   byte[] digest1 = s.digest();
				   BigInteger bigInt1 = new BigInteger(1,digest1);
				   String hashtext1 = bigInt1.toString(16);
			   Admin ch=repo.Check(a.getUser(), hashtext);
			   
			   if(ch != null) {
				   ch.setPass(hashtext1);
				   repo.save(ch);
				   return a;
			   }
				else
					return err;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return err;
		}
		  
		
	}
}
