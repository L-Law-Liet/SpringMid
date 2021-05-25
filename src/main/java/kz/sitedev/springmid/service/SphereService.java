package kz.sitedev.springmid.service;

import kz.sitedev.springmid.entity.Sphere;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SphereService {

    Sphere create(Sphere sphere);
    List<Sphere> getAll();
}
