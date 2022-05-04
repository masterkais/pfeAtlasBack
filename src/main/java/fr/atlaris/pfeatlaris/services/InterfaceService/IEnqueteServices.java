package fr.atlaris.pfeatlaris.services.InterfaceService;

import fr.atlaris.pfeatlaris.entities.Enquete;
import fr.atlaris.pfeatlaris.entities.User;

import java.util.List;

public interface IEnqueteServices {
    Enquete save(Enquete enquete);

    Enquete update(Enquete enquete);

    Enquete findById(Long id);

    List<Enquete> findAllEnquete();

    void delete(Long id);
}
