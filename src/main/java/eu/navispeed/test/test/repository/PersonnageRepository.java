package eu.navispeed.test.test.repository;

import eu.navispeed.test.test.model.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonnageRepository extends JpaRepository<Personnage, Integer> {



}
