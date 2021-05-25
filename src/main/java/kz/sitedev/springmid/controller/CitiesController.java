package kz.sitedev.springmid.controller;

import io.swagger.annotations.Api;
import kz.sitedev.springmid.entity.City;
import kz.sitedev.springmid.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
@Api
public class CitiesController {
    @Autowired
    CityService cityService;

    @GetMapping("")
   public List<City> all(){
        return cityService.all();
    }
}
