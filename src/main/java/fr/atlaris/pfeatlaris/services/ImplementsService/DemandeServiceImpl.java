package fr.atlaris.pfeatlaris.services.ImplementsService;

import fr.atlaris.pfeatlaris.DAO.DemandeDao;
import fr.atlaris.pfeatlaris.entities.Demande;
import fr.atlaris.pfeatlaris.services.InterfaceService.IDemandeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeServiceImpl implements IDemandeServices {
    @Autowired
    DemandeDao demandeDao;

    @Override
    public Demande save(Demande demande) {
        return demandeDao.saveAndFlush(demande);
    }

    @Override
    public Demande update(Demande demande) {
        return demandeDao.saveAndFlush(demande);
    }

    @Override
    public Demande findById(Long id) {
        return Optional.ofNullable(demandeDao.findById(id).get()).orElseThrow(
                () -> new RuntimeException("Entity not found"));
    }

    @Override
    public List<Demande> findAllDemande() {
        return demandeDao.findAll();
    }

    @Override
    public void delete(Long id) {
        demandeDao.deleteById(id);
    }

    @Override
    public Demande createDemandeVide(Demande demande) {
        demande.setState(0);
        demande.setDateCreated(LocalDateTime.now());
        return demandeDao.saveAndFlush(demande);
    }

    @Override
    public Demande envoyerUneDemande(Demande demande) {
        demande.setState(1);
        return demandeDao.saveAndFlush(demande);
    }

    @Override
    public Demande accepterDemande(Demande demande) {
        demande.setState(2);
        demande.setDateAccpted(LocalDateTime.now());
        return demandeDao.saveAndFlush(demande);
    }
}
