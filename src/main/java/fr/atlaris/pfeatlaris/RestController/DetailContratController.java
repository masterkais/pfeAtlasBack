package fr.atlaris.pfeatlaris.RestController;

import fr.atlaris.pfeatlaris.entities.DetailContrat;
import fr.atlaris.pfeatlaris.services.InterfaceService.IDetailContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/detailContrat")
public class DetailContratController {
    @Autowired
    IDetailContratService detailContratService;

    @GetMapping(value = "/detailContrats")
    public List<DetailContrat> getAll() {
        return detailContratService.findAllDetailContrat();
    }

    @GetMapping(value = "/{id}")
    public DetailContrat getOne(@PathVariable Long id) {
        return detailContratService.findById(id);
    }

    @PostMapping()
    public DetailContrat save(@RequestBody DetailContrat detailContrat) {
        return detailContratService.save(detailContrat);
    }

    @PutMapping()
    public DetailContrat update(@RequestBody DetailContrat detailContrat) {
        return detailContratService.update(detailContrat);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        detailContratService.delete(id);
        return true;
    }
}
