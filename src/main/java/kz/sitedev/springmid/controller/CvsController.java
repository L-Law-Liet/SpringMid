package kz.sitedev.springmid.controller;

import io.swagger.annotations.Api;
import kz.sitedev.springmid.entity.Cv;
import kz.sitedev.springmid.entity.User;
import kz.sitedev.springmid.repository.CvRepository;
import kz.sitedev.springmid.service.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cvs")
@Api
public class CvsController {
    @Autowired
    CvService cvService;

    @GetMapping("")
   public List<Cv> all(){
        return cvService.all();
    }

    @GetMapping("/{id}")
    public Cv getById(@PathVariable Long id){
        return cvService.getById(id);
    }

    @GetMapping("/user/{id}")
    public List<Cv> getByUserId(@PathVariable Long id){
        return cvService.getByUserId(id);
    }

    @PostMapping("")
    public Cv create(@Valid @RequestBody Cv cv){
        return cvService.create(cv);
    }

    @PutMapping("/{id}")
    public Cv edit(@PathVariable Long id, @RequestBody Cv cv){
        cv.setId(id);
        return cvService.edit(cv);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        cvService.delete(id);
    }
}
