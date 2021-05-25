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

    @Override
    public List<Job> getByUserId(Long userId) {
        return jobRepository.getByUserId(userId);
    }

    public List<Job> all(){
      return jobRepository.findAll();
    };
//    @Override
//    public List<User> getUsersByJob(Long jobId) {
//        return jobRepository.getUsersByJobId(jobId.intValue());
//    }
    @Override
    public List<Job> getByParams(String keywords, String cityId, String sphereId, String typeId, String salary){
        return jobRepository.getByParams(keywords, cityId, sphereId, typeId, salary);
    }

    public Job update(Job job){
        return jobRepository.saveAndFlush(job);
    }

    @Override
    public Job find(Long id) {
        return jobRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        jobRepository.deleteById(id);
    }

}
