package kz.sitedev.springmid.service.impl;
import kz.sitedev.springmid.entity.Sphere;
import kz.sitedev.springmid.repository.SphereRepository;
import kz.sitedev.springmid.service.SphereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SphereServiceImpl implements SphereService {

    @Autowired
    SphereRepository sphereRepository;

    @Override
    public void create(Sphere sphere) {
        sphereRepository.save(sphere);
    }

    public List<Sphere> getAll() {
        return sphereRepository.findAll();
    }
}
