package dz.univebechar.amd;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AdminRepo extends CrudRepository<Admin, Integer>{
	@Query("select u from admin u where u.user = :user and u.pass = :pass")
	  Admin Check(@Param("user") String user,
	                                 @Param("pass") String pass);
	
}
