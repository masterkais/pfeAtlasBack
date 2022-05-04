package fr.atlaris.pfeatlaris.services.InterfaceService;

import fr.atlaris.pfeatlaris.entities.DetailContrat;
import fr.atlaris.pfeatlaris.entities.Enquete;

import java.util.List;

public interface IDetailContratService {
    DetailContrat save(DetailContrat detailContrat);

    DetailContrat update(DetailContrat detailContrat);

    DetailContrat findById(Long id);

    List<DetailContrat> findAllDetailContrat();

    void delete(Long id);
}
