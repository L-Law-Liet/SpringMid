package kz.sitedev.springmid.controller;

import io.swagger.annotations.Api;
import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.User;
import kz.sitedev.springmid.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@Api
public class JobsController {
    @Autowired
    JobService jobService;

    @GetMapping("")
    public List<Job> all(){
        return jobService.all();
    }

    @GetMapping("/{id}")
    public Job find(@PathVariable Long id){
        return jobService.find(id);
    }

    @PostMapping("")
    public void create(Job job){
        jobService.create(job);
    }

    @PutMapping("/{id}")
    public Job update(@PathVariable Long id,
                       @RequestBody Job job) {
        job.setId(id);
        return jobService.update(job);
    }
    @PatchMapping("/{id}")
    public Job updateTitle(@PathVariable Long id,
                               @RequestParam String title) {
        Job job = jobService.find(id);
        job.setTitle(title);
        return jobService.update(job);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        jobService.delete(id);
    }

    @GetMapping("/find/sphere/{id}")
    public List<Job> findJobsBySphereId(@PathVariable Long sphereId){
        return jobService.findJobsBySphereId(sphereId);
    }
}
