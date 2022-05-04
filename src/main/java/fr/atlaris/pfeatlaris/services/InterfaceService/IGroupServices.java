package fr.atlaris.pfeatlaris.services.InterfaceService;

import fr.atlaris.pfeatlaris.entities.Group;

import java.util.List;

public interface IGroupServices {
    Group save(Group groupDto);

    Group update(Group groupDto);

    Group findById(Long id);

    void addRoleToUse(String userName,String roleName);

    List<Group> findAllEGroup();

    void delete(Long id);
}
