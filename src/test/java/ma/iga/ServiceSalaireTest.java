package ma.iga;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ma.iga.model.Personne;
import ma.iga.service.PersonneService;
import ma.iga.service.SalaireServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ServiceSalaireTest {

    @Mock
    private PersonneService personneService;
    
    @InjectMocks
    private SalaireServiceImpl salaireService;

     

    @BeforeEach
    void setMockOutput() {
    	Personne personne = new Personne();
    	
    	personne.setId(1L);
    	personne.setMatricule("M45871");
    	personne.setNom("Amin");
    	personne.setPrenom("Amin");
    	personne.setRecrutement(new GregorianCalendar(2019, 1 - 1, 1).getTime());
    	personne.setSalaireBase(100.0);
    			
        when(personneService.getById(1L)).thenReturn(personne);
    }

    @Test
    public void calculeSalaire() {
    	Double salaire = salaireService.calculeSalaire(1L);
        assertThat(salaire).isEqualTo(110.0);
    }
}