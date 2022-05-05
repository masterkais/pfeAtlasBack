package fr.atlaris.pfeatlaris.RestController;

import fr.atlaris.pfeatlaris.entities.User;
import fr.atlaris.pfeatlaris.services.InterfaceService.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserServices userServices;

    @GetMapping(value = "/users")
    public List<User> getAll() {
        return userServices.findAllUser();
    }

    @GetMapping(value = "/{id}")
    public User getOne(@PathVariable Long id) {
        return userServices.findById(id);
    }

    @PostMapping()
    public User save(@RequestBody User user) {
        return userServices.save(user);
    }

    @PutMapping()
    public User update(@RequestBody User user) {
        return userServices.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        userServices.delete(id);
        return true;
    }
}
