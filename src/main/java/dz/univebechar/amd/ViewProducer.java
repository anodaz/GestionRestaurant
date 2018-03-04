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
@RequestMapping("producer")
public class ViewProducer {
	@Autowired
	ProducerRepo repo;
	@GetMapping(path = "All",produces = "application/json")
	public List<Producer> getsProducer(){
		List<Producer> producer=(List<Producer>) repo.findAll();
		return producer;
				
	}
	
	@GetMapping(path = "View/{id}",produces = "application/json")
	public Producer getProducer(@PathVariable  int id){
		//List<Admin> admin=(List<Admin>) repo.findAll();
		Producer producer=repo.findOne(id);
		return producer;
				
	}
	@DeleteMapping(path = "Delete/{id}",produces = "application/json")
	public Producer DeleteProducer(@PathVariable  int id){
		//List<Admin> admin=(List<Admin>) repo.findAll();*
		Producer producer=repo.findOne(id);
		if(repo.exists(id)) {
			repo.delete(id);
		}
		
		return producer;
	}
	//@PostMapping("Add")
	
	@PostMapping(path = "Insert", consumes = "application/json", produces = "application/json")
	public Producer InsertProducer(@RequestBody Producer a){
		//List<Admin> admin=(List<Admin>) repo.findAll();*
		Producer producer=repo.save(a);
		return producer;
				
	}
	
	@PutMapping(path = "Update", consumes = "application/json", produces = "application/json")
	public Producer UpdateProducer(@RequestBody Producer a){
		//List<Admin> admin=(List<Admin>) repo.findAll();*
		
		Producer producer=repo.save(a);
		return producer;
				
	}
}
