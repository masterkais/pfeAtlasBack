package fr.atlaris.pfeatlaris.DAO;

import fr.atlaris.pfeatlaris.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupDao extends JpaRepository<Group, Long> {
    Group findByPrivileged(String privileged);
}
