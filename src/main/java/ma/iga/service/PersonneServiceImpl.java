package ma.iga.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.iga.Repository.PersonneRepository;
import ma.iga.model.Personne;

@Service
public class PersonneServiceImpl implements PersonneService   {

	@Autowired
	private PersonneRepository personeRepository;
	
	@Override
	public List<Personne> getAll() {
		return personeRepository.findAll();
	}
	
	@Override
	public Personne getById(Long id) {
		Optional<Personne> opPersonne =  personeRepository.findById(id);
		
		if(opPersonne.isPresent()) {
			return opPersonne.get();	
		}else  {
			throw new RuntimeException("Personne not Found");
		}
		
	}

	@Override
	public Personne add(Personne personne) {
		personne.setId(null);
		personeRepository.save(personne);
		return personne;
	}

	@Override
	public Personne update(Personne personne) {
		personeRepository.save(personne);
		return personne;
	}

	@Override
	public Boolean delete(Long id) {
		personeRepository.deleteById(id);
		return true;
	}

}
