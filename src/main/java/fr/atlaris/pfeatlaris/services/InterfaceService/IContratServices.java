package fr.atlaris.pfeatlaris.services.InterfaceService;

import fr.atlaris.pfeatlaris.entities.Contrat;
import fr.atlaris.pfeatlaris.entities.Demande;

import java.util.List;

public interface IContratServices{
    Contrat save(Contrat contrat);

    Contrat update(Contrat contrat);

    Contrat  findById(Long id);

    List<Contrat> findAllContrat();

    void delete(Long id);
}
