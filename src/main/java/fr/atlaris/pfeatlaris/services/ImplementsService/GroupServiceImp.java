package fr.atlaris.pfeatlaris.services.ImplementsService;

import fr.atlaris.pfeatlaris.DAO.GroupDao;
import fr.atlaris.pfeatlaris.DAO.UserDao;
import fr.atlaris.pfeatlaris.entities.Group;
import fr.atlaris.pfeatlaris.entities.User;
import fr.atlaris.pfeatlaris.services.InterfaceService.IGroupServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GroupServiceImp implements IGroupServices {
    @Autowired
    GroupDao groupDao;
    @Autowired
    UserDao userDao;
    @Override
    public Group save(Group groupDto) {
        return groupDao.save(groupDto);
    }

    @Override
    public Group update(Group groupDto) {
        return groupDao.saveAndFlush(groupDto);
    }

    @Override
    public Group findById(Long id) {
        return Optional.ofNullable(groupDao.findById(id).get()).orElseThrow(
                () -> new RuntimeException("Entity not found"));
    }

    @Override
    public void addRoleToUse(String userName, String roleName) {
        Group group=groupDao.findByPrivileged(roleName);
        User user=userDao.findByUserName(userName);
        user.getGroups().add(group);
        userDao.save(user);
    }

    @Override
    public List<Group> findAllEGroup() {
        return groupDao.findAll();
    }

    @Override
    public void delete(Long id) {
groupDao.deleteById(id);
    }
}
