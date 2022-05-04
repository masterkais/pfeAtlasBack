package fr.atlaris.pfeatlaris.RestController;

import fr.atlaris.pfeatlaris.entities.Demande;
import fr.atlaris.pfeatlaris.entities.User;
import fr.atlaris.pfeatlaris.services.InterfaceService.IDemandeServices;
import fr.atlaris.pfeatlaris.services.InterfaceService.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/demande")
public class DemandeController {
    @Autowired
    IDemandeServices demandeServices;
    @Autowired
    IUserServices userServices;
    @GetMapping(value = "/demandes")
    public List<Demande> getAll() {
        return demandeServices.findAllDemande();
    }

    @GetMapping(value = "/{id}")
    public Demande getOne(@PathVariable Long id) {
        return demandeServices.findById(id);
    }

    @PostMapping()
    public Demande save(@RequestBody Demande demande) {
        return demandeServices.save(demande);
    }

    @PutMapping()
    public Demande update(@RequestBody Demande demande) {
        return demandeServices.update(demande);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        demandeServices.delete(id);
        return true;
    }

    @PostMapping("/createNewDemande")
    public Demande createDemandeVide(@RequestParam Long idClient) {
        User client=userServices.findById(idClient);
        Demande demande=new Demande();
        demande.setClient(client);
        return demandeServices.createDemandeVide(demande);
    }

    @PostMapping("/accepterDemande")
    public Demande accepterDemande(@RequestParam Long idDemande) {
        Demande demande = demandeServices.findById(idDemande);
        return demandeServices.accepterDemande(demande);
    }

    @PostMapping("/envoyerUneDemande")
    public Demande envoyerUneDemande(@RequestParam Long idDemande,@RequestParam String matFiscal){
        Demande demande = demandeServices.findById(idDemande);
        demande.setMatriculeFiscalSociete(matFiscal);
        return demandeServices.envoyerUneDemande(demande);
    }
}
