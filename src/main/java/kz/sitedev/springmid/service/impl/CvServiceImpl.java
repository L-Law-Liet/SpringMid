package kz.sitedev.springmid.service.impl;
import kz.sitedev.springmid.entity.Cv;
import kz.sitedev.springmid.repository.CvRepository;
import kz.sitedev.springmid.service.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvServiceImpl implements CvService {

    @Autowired
    CvRepository cvRepository;

    public List<Cv> all() {
        return cvRepository.findAll();
    }

    @Override
    public List<Cv> getByUserId(Long id) {
        return cvRepository.getByUserId(id);
    }

    public Cv getById(Long id) {
        return cvRepository.getById(id);
    }

    @Override
    public Cv create(Cv cv) {
        return cvRepository.saveAndFlush(cv);
    }

    @Override
    public Cv edit(Cv cv) {
        return cvRepository.saveAndFlush(cv);
    }

    @Override
    public void delete(Long id) {
        cvRepository.deleteById(id);
    }
}
