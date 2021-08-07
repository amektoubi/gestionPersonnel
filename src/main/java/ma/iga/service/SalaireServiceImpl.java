package ma.iga.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.iga.model.Personne;

@Service
public class SalaireServiceImpl implements SalaireService   {

	Double TAUX_ANNUEL = 0.05;
	
	@Autowired
	private PersonneService personneService;
	
	@Override
	public Double calculeSalaire(Long idPersonne) {
		Personne personne = personneService.getById(idPersonne);
		int annesEntreprise = getYear(new Date())-getYear(personne.getRecrutement());
		
		
		System.out.println(TAUX_ANNUEL);
		System.out.println(annesEntreprise);
		
		return new BigDecimal(personne.getSalaireBase())
				.multiply(new BigDecimal(annesEntreprise))
				.multiply(new BigDecimal(TAUX_ANNUEL))
				.add(new BigDecimal(personne.getSalaireBase()))
				.doubleValue();
				
	}

	private int getYear(Date date) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				return calendar.get(Calendar.YEAR);
	}
	
}
