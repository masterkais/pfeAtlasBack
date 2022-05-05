package fr.atlaris.pfeatlaris.RestController;

import fr.atlaris.pfeatlaris.DAO.ContratDao;
import fr.atlaris.pfeatlaris.entities.Contrat;
import fr.atlaris.pfeatlaris.entities.Group;
import fr.atlaris.pfeatlaris.entities.User;
import fr.atlaris.pfeatlaris.services.InterfaceService.IContratServices;
import fr.atlaris.pfeatlaris.services.InterfaceService.IGroupServices;
import fr.atlaris.pfeatlaris.services.InterfaceService.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/contrat")
public class ContratController {
    @Autowired
    IContratServices contratServices;
    @Autowired
    IUserServices userServices;
    @GetMapping(value = "/contrats")
    public List<Contrat> getAll(){
        return contratServices.findAllContrat();
    }
    @GetMapping(value = "/{id}")
    public Contrat getOne(@PathVariable Long id){
        return contratServices.findById(id);
    }
    @PostMapping()
    public Contrat save(@RequestBody  Contrat contrat){
        return contratServices.save(contrat);
    }
    @PutMapping()
    public Contrat update(@RequestBody Contrat contrat){
        return contratServices.update(contrat);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        contratServices.delete(id);
        return true;
    }


}
