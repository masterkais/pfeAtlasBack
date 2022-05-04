package fr.atlaris.pfeatlaris.services.ImplementsService;

import fr.atlaris.pfeatlaris.DAO.DetailContratDao;
import fr.atlaris.pfeatlaris.entities.DetailContrat;
import fr.atlaris.pfeatlaris.services.InterfaceService.IDetailContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DetailContratServiceImp implements IDetailContratService {
    @Autowired
    DetailContratDao detailContratDao;

    @Override
    public DetailContrat save(DetailContrat detailContrat) {
        return detailContratDao.saveAndFlush(detailContrat);
    }

    @Override
    public DetailContrat update(DetailContrat detailContrat) {
        return detailContratDao.saveAndFlush(detailContrat);
    }

    @Override
    public DetailContrat findById(Long id) {
        return Optional.ofNullable(detailContratDao.findById(id).get()).orElseThrow(
                () -> new RuntimeException("Entity not found"));
    }

    @Override
    public List<DetailContrat> findAllDetailContrat() {
        return detailContratDao.findAll();
    }

    @Override
    public void delete(Long id) {
        detailContratDao.deleteById(id);
    }
}
