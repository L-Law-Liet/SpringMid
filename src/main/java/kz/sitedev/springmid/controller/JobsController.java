package kz.sitedev.springmid.controller;

import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.User;
import kz.sitedev.springmid.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class JobsController {
    @Autowired
    JobService jobService;

    public void create(Job job){
        jobService.create(job);
    }

    public void delete(Long id){
        jobService.delete(id);
    }


    public List<Job> findJobsBySphereId(int sphereId){
        return jobService.findJobsBySphereId(sphereId);
    }
}
