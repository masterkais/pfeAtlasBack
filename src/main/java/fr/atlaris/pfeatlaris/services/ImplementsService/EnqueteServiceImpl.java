package fr.atlaris.pfeatlaris.services.ImplementsService;

import fr.atlaris.pfeatlaris.DAO.EnqueteDao;
import fr.atlaris.pfeatlaris.entities.Enquete;
import fr.atlaris.pfeatlaris.services.InterfaceService.IEnqueteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EnqueteServiceImpl implements IEnqueteServices {
    @Autowired
    EnqueteDao enqueteDao;
    @Override
    public Enquete save(Enquete enquete) {
        return enqueteDao.saveAndFlush(enquete);
    }

    @Override
    public Enquete update(Enquete enquete) {
        return enqueteDao.saveAndFlush(enquete);
    }

    @Override
    public Enquete findById(Long id) {
        return Optional.ofNullable(enqueteDao.findById(id).get()).orElseThrow(
                () -> new RuntimeException("Entity not found"));
    }

    @Override
    public List<Enquete> findAllEnquete() {
        return enqueteDao.findAll();
    }

    @Override
    public void delete(Long id) {
        enqueteDao.deleteById(id);
    }
}
