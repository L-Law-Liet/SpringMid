package kz.sitedev.springmid.service;

import kz.sitedev.springmid.entity.Cv;
import kz.sitedev.springmid.entity.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CvService {

    List<Cv> all();
    List<Cv> getByUserId(Long id);
    Cv getById(Long id);
    Cv create(Cv cv);
    Cv edit(Cv cv);
    void delete(Long id);

}
