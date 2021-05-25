package kz.sitedev.springmid.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import kz.sitedev.springmid.entity.Cv;
import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.JobCv;
import kz.sitedev.springmid.entity.User;
import kz.sitedev.springmid.repository.CvRepository;
import kz.sitedev.springmid.repository.JobCvRepository;
import kz.sitedev.springmid.service.CvService;
import kz.sitedev.springmid.service.JobCvService;
import kz.sitedev.springmid.service.JobService;
import kz.sitedev.springmid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jobs/cvs")
@Api
public class JobCvsController {
    @Autowired
    JobCvService jobCvService;

    @Autowired
    UserService userService;

    @Autowired
    JobService jobService;

    @Autowired
    CvService cvService;

    @GetMapping("")
    public List<JobCv> all(){
        return jobCvService.all();
    }

    @GetMapping("/user")
    public List<JobCv> getByUserId(@RequestHeader Map<String, String> headers){
        Claims body = Jwts.parser()
                .setSigningKey("secret-key".getBytes())
                .parseClaimsJws(headers.get("authorization").substring(7))
                .getBody();
        User user = userService.getByUsername(body.getSubject());
        List<Long> ids = new ArrayList<>();

        if (user.getRoles().get(0).getId() == 2){
            List<Cv> cvs = cvService.getByUserId(user.getId());
            for (Cv cv : cvs){
                ids.add(cv.getId());
            }
            return jobCvService.getByCvIds(ids);
        }
        List<Job> jobs = jobService.getByUserId(user.getId());
        for (Job job : jobs){
            ids.add(job.getId());
        }
        return jobCvService.getByJobIds(ids);
    }

    @GetMapping("/{id}")
    public JobCv get(@PathVariable Long id){
        return jobCvService.get(id);
    }

    @PostMapping("")
    public JobCv create(@RequestBody JobCv jobCv){
        return jobCvService.create(jobCv);
    }

    @PutMapping("/{id}/cv")
    public JobCv applyCv(@PathVariable Long id, @RequestBody Map<String, String> params){
        JobCv jobCv = jobCvService.get(id);
        jobCv.setCvApplied(Integer.parseInt(params.get("cv")));
        return jobCvService.edit(jobCv);
    }

    @PutMapping("/{id}/job")
    public JobCv applyJob(@PathVariable Long id, @RequestBody Map<String, String> params){
        System.out.println(params.get("job"));
        JobCv jobCv = jobCvService.get(id);
        jobCv.setJobApplied(Integer.parseInt(params.get("job")));
        return jobCvService.edit(jobCv);
    }
}
