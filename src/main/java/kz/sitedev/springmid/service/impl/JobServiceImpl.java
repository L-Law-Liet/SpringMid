package kz.sitedev.springmid.service.impl;
import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.User;
import kz.sitedev.springmid.repository.JobRepository;
import kz.sitedev.springmid.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobRepository jobRepository;

    @Override
    public void create(Job job) {
        jobRepository.save(job);
    }

    @Override
    public List<Job> findJobsBySphereId(Long sphereId) {
        return jobRepository.findJobsBySphereId(sphereId);
    }
    public List<Job> all(){
      return jobRepository.findAll();
    };
//    @Override
//    public List<User> getUsersByJob(Long jobId) {
//        return jobRepository.getUsersByJobId(jobId.intValue());
//    }

    public Job update(Job job){
        return jobRepository.saveAndFlush(job);
    }

    @Override
    public Job find(Long id) {
        return jobRepository.getById(id);
    }

    @Override
    public void delete(Long id) {
        jobRepository.deleteById(id);
    }

}
