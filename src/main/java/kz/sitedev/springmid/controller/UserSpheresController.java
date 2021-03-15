package kz.sitedev.springmid.controller;

import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.User;
import kz.sitedev.springmid.entity.UserSphere;
import kz.sitedev.springmid.service.UserService;
import kz.sitedev.springmid.service.UserSphereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserSpheresController {
    @Autowired
    UserSphereService userSphereService;

    public void create(UserSphere userSphere){
        userSphereService.create(userSphere);
    }
}
