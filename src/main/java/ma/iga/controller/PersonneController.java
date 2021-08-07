package ma.iga.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.iga.model.Personne;
import ma.iga.service.PersonneService;
import ma.iga.service.SalaireService;

@RestController
@RequestMapping("api/v1/personne")
public class PersonneController    {

	@Autowired
	private PersonneService personeService;
	
	@Autowired
	private SalaireService salaireService;
	
	
	@GetMapping("")
	public List<Personne> getAll() {
		return personeService.getAll();
	}
	
	@GetMapping("{id}")
	public Personne getById(@PathVariable("id") Long id) {
		return personeService.getById(id);
	}
	
	@PostMapping("")
	public Personne add(@RequestBody Personne personne) {
		return personeService.add(personne);
	}
	
	@PutMapping("{id}")
	public Personne update(@PathVariable("id") Long id ,@RequestBody Personne personne) {
		personne.setId(id);
		return personeService.update(personne);
	}
	
	@DeleteMapping("{id}")
	public Boolean delete(@PathVariable("id") Long id ) {
		return personeService.delete(id);
	}
	
	@GetMapping("{id}/salaire")
	public Double getSalaire(@PathVariable("id") Long id) {
		return salaireService.calculeSalaire(id);
	}

}
