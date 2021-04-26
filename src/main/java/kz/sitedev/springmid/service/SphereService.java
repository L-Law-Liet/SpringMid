package kz.sitedev.springmid.service;

import kz.sitedev.springmid.entity.Sphere;

import java.util.List;

public interface SphereService {

    Sphere create(Sphere sphere);
    List<Sphere> getAll();
}
