package ma.iga;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import ma.iga.model.Personne;



	@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
	public class PersonneController {

	    @LocalServerPort
	    private int port;

	    private String url;

	    @Autowired
	    private TestRestTemplate restTemplate;

	    @BeforeEach
	    public void setUp() {
	        url = String.format("http://localhost:%d/", port);
	        Personne personne = new Personne();
	    	
	    	personne.setMatricule("M45871");
	    	personne.setNom("Amin");
	    	personne.setPrenom("Amin");
	    	personne.setRecrutement(new GregorianCalendar(2019, 1 - 1, 1).getTime());
	    	personne.setSalaireBase(100.0);
	    			
	        
	        this.restTemplate.postForEntity(url+"/api/v1/personne",personne, Personne.class);
	        
	    }

	    @Test
	    public void calculeSalaire() {
	        assertThat(this.restTemplate.getForObject(url+"/api/v1/personne/1/salaire", String.class)).isEqualTo("115.0");
	    }
	}
