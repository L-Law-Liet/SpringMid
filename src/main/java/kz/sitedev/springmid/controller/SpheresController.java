package kz.sitedev.springmid.controller;

import io.swagger.annotations.Api;
import kz.sitedev.springmid.entity.Sphere;
import kz.sitedev.springmid.service.SphereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spheres")
@Api
public class SpheresController {
    @Autowired
    SphereService sphereService;

    @GetMapping("")
   public List<Sphere> all(){
        return sphereService.getAll();
    }

    @PostMapping("")
    public Sphere create(Sphere sphere){
        return sphereService.create(sphere);
    }
}
