package kz.sitedev.springmid.controller;

import io.swagger.annotations.Api;
import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.User;
import kz.sitedev.springmid.entity.UserSphere;
import kz.sitedev.springmid.service.UserService;
import kz.sitedev.springmid.service.UserSphereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/spheres")
@Api
public class UserSpheresController {
    @Autowired
    UserSphereService userSphereService;
    @PostMapping("")
    public void create(UserSphere userSphere){
        userSphereService.create(userSphere);
    }
}
