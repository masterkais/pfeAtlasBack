package fr.atlaris.pfeatlaris.DAO;

import fr.atlaris.pfeatlaris.entities.Enquete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnqueteDao extends JpaRepository<Enquete,Long> {
}
