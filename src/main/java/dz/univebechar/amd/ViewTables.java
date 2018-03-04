package dz.univebechar.amd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Tables")
public class ViewTables {
	@Autowired
	TablesRepo repo;
	@GetMapping("All")
	public List<Tables> getsTables(){
		List<Tables> tables=(List<Tables>) repo.findAll();
		return tables;
				
	}
	@GetMapping("View/{id}")
	public Tables getTables(@PathVariable  int id){
		//List<Admin> admin=(List<Admin>) repo.findAll();
		Tables tables=repo.findOne(id);
		return tables;
				
	}
	@DeleteMapping("Delete/{id}")
	public Tables DeleteTables(@PathVariable  int id){
		//List<Admin> admin=(List<Admin>) repo.findAll();*
		Tables tables=repo.findOne(id);
		if(repo.exists(id)) {
			repo.delete(id);
		}
		
		return tables;
	}
	//@PostMapping("Add")
	@PostMapping(path = "Insert", consumes = "application/json", produces = "application/json")
	public Tables InsertTables(@RequestBody Tables a){
		//List<Admin> admin=(List<Admin>) repo.findAll();*
		Tables tables=repo.save(a);
		return tables;
				
	}
	
	@PutMapping(path = "Update", consumes = "application/json", produces = "application/json")
	public Tables UpdateTables(@RequestBody Tables a){
		//List<Admin> admin=(List<Admin>) repo.findAll();*
		
		Tables tables=repo.save(a);
		return tables;
				
	}
}
