package kz.sitedev.springmid.controller;

import kz.sitedev.springmid.entity.Sphere;
import kz.sitedev.springmid.service.SphereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SpheresController {
    @Autowired
    SphereService sphereService;

   public List<Sphere> all(){
        return sphereService.getAll();
    }
}
