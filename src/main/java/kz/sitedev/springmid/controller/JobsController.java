package kz.sitedev.springmid.controller;

import io.swagger.annotations.Api;
import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.User;
import kz.sitedev.springmid.events.JobEvent;
import kz.sitedev.springmid.repository.JobRepository;
import kz.sitedev.springmid.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jobs")
@Api
public class JobsController implements ApplicationEventPublisherAware {
    @Autowired
    JobService jobService;

    @Autowired
    JobRepository jobRepository;

    private ApplicationEventPublisher eventPublisher;

        @GetMapping("")
        public List<Job> all(){
            return jobService.all();
        }

    @GetMapping("/{id}")
    public Job find(@PathVariable String id){
        return jobRepository.findById(Long.parseLong(id)).get();
    }

    @PostMapping("")
    public void create(@RequestBody Job job){
        job.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        System.out.println(job.toString());
        this.eventPublisher.publishEvent(new JobEvent(this, job.getSphereId()));
        System.out.println(job.toString());
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
        job.setName(title);
        return jobService.update(job);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        jobService.delete(id);
    }

    @GetMapping("/sphere/{id}")
    public List<Job> findJobsBySphereId(@PathVariable Long id){
        return jobService.findJobsBySphereId(id);
    }

    @GetMapping("/find/user/{id}")
    public List<Job> getByUserId(@PathVariable String id){
        Long userId = Long.parseLong(id);
        return jobService.getByUserId(userId);
    }

    @PostMapping("/filter")
    public List<Job> getByParams(@RequestBody Map<String, String> json){
            String keywords = json.get("keywords");
            String cityId = json.get("cityId");
            String sphereId = json.get("sphereId");
            String typeId = json.get("typeId");
            String salary = (json.get("salary") == null) ? "0" : json.get("salary");
            return jobService.getByParams(keywords, cityId, sphereId, typeId, salary);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
