package fr.atlaris.pfeatlaris.services.ImplementsService;

import fr.atlaris.pfeatlaris.DAO.UserDao;
import fr.atlaris.pfeatlaris.entities.User;
import fr.atlaris.pfeatlaris.services.InterfaceService.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements IUserServices {
    @Autowired
    private UserDao userDao;
    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User update(User user) {
        User userResult=userDao.saveAndFlush(user);
        return userResult;
    }

    @Override
    public User findById(Long id) {
        return Optional.ofNullable(userDao.findById(id).get()).orElseThrow(
                () -> new RuntimeException("Entity not found"));
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAll();
    }

    @Override
    public void delete(Long id) {
     userDao.deleteById(id);
    }
}
