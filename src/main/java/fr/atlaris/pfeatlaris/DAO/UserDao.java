package fr.atlaris.pfeatlaris.DAO;

import fr.atlaris.pfeatlaris.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUserName(String firstName);

    User findByUserNameAndPassword(String login, String password);

}
