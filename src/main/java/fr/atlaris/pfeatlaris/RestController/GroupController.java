package fr.atlaris.pfeatlaris.RestController;

import fr.atlaris.pfeatlaris.entities.Group;
import fr.atlaris.pfeatlaris.services.InterfaceService.IGroupServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/group")
public class GroupController {
    private final IGroupServices groupService;
    @Autowired
    public GroupController(IGroupServices groupService) {
        this.groupService = groupService;
    }
    @GetMapping(value = "/groups")
    public List<Group> findAll() {
        return groupService.findAllEGroup();
    }
    @GetMapping(value = "/{id}")
    public Group getGroup(@PathVariable Long id) {
        return groupService.findById(id);
    }
    @PostMapping()
    public Group save(@RequestBody @Valid Group group) {
        return groupService.save(group);
    }
    @PostMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam String userName,@RequestParam String roleName) {
         groupService.addRoleToUse(userName,roleName);
         return "success";
    }
    @PutMapping()
    public Group update(@RequestBody @Valid Group group) {
        return groupService.update(group);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        groupService.delete(id);
        return true;
    }
}
