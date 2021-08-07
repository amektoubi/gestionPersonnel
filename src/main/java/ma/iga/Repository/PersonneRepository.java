package ma.iga.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.iga.model.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long>  {
}
