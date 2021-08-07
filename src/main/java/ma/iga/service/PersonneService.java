package ma.iga.service;

import java.util.List;

import ma.iga.model.Personne;

public interface PersonneService  {
	public List<Personne> getAll();
	public Personne add(Personne personne);
	public Personne update(Personne personne);
	public Boolean  delete(Long id);
	public Personne getById(Long id);
}
