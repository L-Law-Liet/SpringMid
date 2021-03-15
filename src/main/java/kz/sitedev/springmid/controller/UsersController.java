package kz.sitedev.springmid.controller;

import kz.sitedev.springmid.entity.Sphere;
import kz.sitedev.springmid.entity.User;
import kz.sitedev.springmid.service.SphereService;
import kz.sitedev.springmid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    UserService userService;

   public List<User> all(){
        return userService.getAll();
    }

    public List<User> getUsersByJob(Long jobId) {
        return userService.getUsersByJob(jobId);
    }
}
