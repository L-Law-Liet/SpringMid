package kz.sitedev.springmid.controller;

import io.swagger.annotations.Api;
import kz.sitedev.springmid.entity.Cv;
import kz.sitedev.springmid.entity.Sub;
import kz.sitedev.springmid.entity.User;
import kz.sitedev.springmid.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/subs")
@Api
public class SubsController {
    @Autowired
    SubService subService;

    @GetMapping("")
    public List<Sub> getAll() {
        return subService.getAll();
    }

    @GetMapping("/user/{id}")
    public List<Sub> getByUserId(@PathVariable String id){
        return subService.getByUserId(Long.parseLong(id));
    }

    @PostMapping("")
    public Sub create(@Valid @RequestBody Sub sub){
        return subService.create(sub);
    }

    @PutMapping("/{id}")
    public Sub edit(@PathVariable Long id, @RequestBody Sub sub){
        sub.setId(id);
        return subService.edit(sub);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        subService.delete(id);
    }
}
