package fr.atlaris.pfeatlaris.RestController;

import fr.atlaris.pfeatlaris.DAO.EnqueteDao;
import fr.atlaris.pfeatlaris.entities.Contrat;
import fr.atlaris.pfeatlaris.entities.Demande;
import fr.atlaris.pfeatlaris.entities.Enquete;
import fr.atlaris.pfeatlaris.services.InterfaceService.IDemandeServices;
import fr.atlaris.pfeatlaris.services.InterfaceService.IEnqueteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/enquete")
public class EnqueteController {
    @Autowired
    IEnqueteServices enqueteServices;
    @Autowired
    IDemandeServices demandeServices;
    @GetMapping(value = "/enquetes")
    public List<Enquete> getAll(){
        return enqueteServices.findAllEnquete();
    }
    @GetMapping(value = "/{id}")
    public Enquete getOne(@PathVariable Long id){
        return enqueteServices.findById(id);
    }
    @PostMapping("/effectuerUneEnquete")
    public Enquete effectuerUneEnquete(@RequestParam Long idDemande){
        Demande demande=demandeServices.findById(idDemande);
        Enquete enquete=new Enquete();
        enquete.setDateEnquete(LocalDateTime.now());
        enquete.setState(1);
        enquete.setDemande(demande);
        return enqueteServices.save(enquete);
    }
    @PostMapping("cloturerEnquete")
    public Enquete cloturerEnquete(@RequestParam Long enqueteId,@RequestParam String pathRapport){
        Enquete enquete=enqueteServices.findById(enqueteId);
        enquete.setState(2);
        enquete.setPathRapport(pathRapport);
        enquete.setDateFiniEnquete(LocalDateTime.now());
        return enqueteServices.save(enquete);
    }
    @PutMapping()
    public Enquete update(@RequestBody Enquete enquete){
        return enqueteServices.update(enquete);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        enqueteServices.delete(id);
        return true;
    }
}
