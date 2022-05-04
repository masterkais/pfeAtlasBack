package fr.atlaris.pfeatlaris.services.ImplementsService;

import fr.atlaris.pfeatlaris.DAO.ContratDao;
import fr.atlaris.pfeatlaris.entities.Contrat;
import fr.atlaris.pfeatlaris.services.InterfaceService.IContratServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContratServiceImp implements IContratServices {
    @Autowired
    ContratDao contratDao;

    @Override
    public Contrat save(Contrat contrat) {
        return contratDao.saveAndFlush(contrat);
    }

    @Override
    public Contrat update(Contrat contrat) {
        return contratDao.saveAndFlush(contrat);
    }

    @Override
    public Contrat findById(Long id) {
        return Optional.ofNullable(contratDao.findById(id).get()).orElseThrow(
                () -> new RuntimeException("Entity not found"));
    }

    @Override
    public List<Contrat> findAllContrat() {
        return contratDao.findAll();
    }

    @Override
    public void delete(Long id) {
        contratDao.deleteById(id);
    }
}
