package fr.atlaris.pfeatlaris.DAO;

import fr.atlaris.pfeatlaris.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratDao extends JpaRepository<Contrat, Long> {
}
