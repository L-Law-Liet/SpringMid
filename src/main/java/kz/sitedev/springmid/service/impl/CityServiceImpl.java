package kz.sitedev.springmid.service.impl;
import kz.sitedev.springmid.entity.City;
import kz.sitedev.springmid.repository.CityRepository;
import kz.sitedev.springmid.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    public List<City> all() {
        return cityRepository.findAll();
    }
}
