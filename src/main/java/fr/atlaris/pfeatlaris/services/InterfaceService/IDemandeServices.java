package fr.atlaris.pfeatlaris.services.InterfaceService;

import fr.atlaris.pfeatlaris.entities.Demande;
import fr.atlaris.pfeatlaris.entities.DetailContrat;
import fr.atlaris.pfeatlaris.entities.Enquete;

import java.util.List;

public interface IDemandeServices {
    Demande save(Demande demande);

    Demande update(Demande demande);

    Demande  findById(Long id);

    List<Demande > findAllDemande();

    void delete(Long id);


    Demande createDemandeVide(Demande demande);

    Demande envoyerUneDemande(Demande demande);

    Demande accepterDemande(Demande demande);
}
