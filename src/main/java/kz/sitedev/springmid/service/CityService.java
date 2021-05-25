package kz.sitedev.springmid.service;

import kz.sitedev.springmid.entity.City;
import kz.sitedev.springmid.entity.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    List<City> all();
}
