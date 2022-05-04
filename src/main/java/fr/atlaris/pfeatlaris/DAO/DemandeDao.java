package fr.atlaris.pfeatlaris.DAO;

import fr.atlaris.pfeatlaris.entities.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeDao extends JpaRepository<Demande, Long> {
}
