package fr.atlaris.pfeatlaris.services.InterfaceService;

import fr.atlaris.pfeatlaris.entities.Group;
import fr.atlaris.pfeatlaris.entities.User;

import java.util.List;

public interface IUserServices {
    User save(User user);

    User update(User user);

    User findById(Long id);

    List<User> findAllUser();

    void delete(Long id);
}
