package kz.sitedev.springmid.controller;

import io.swagger.annotations.Api;
import kz.sitedev.springmid.entity.Type;
import kz.sitedev.springmid.repository.TypeRepository;
import kz.sitedev.springmid.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/types")
@Api
public class TypesController {
    @Autowired
    TypeService typeService;
    @GetMapping("")
   public List<Type> all(){
        return typeService.all();
    }
}
