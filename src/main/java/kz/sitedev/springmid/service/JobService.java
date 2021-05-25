package kz.sitedev.springmid.service;

import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.Sphere;
import kz.sitedev.springmid.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {

    void create(Job job);
    List<Job> findJobsBySphereId(Long sphereId);
    List<Job> getByUserId(Long userId);
//    List<User> getUsersByJob(Long jobId);
    void delete(Long id);
    List<Job> all();
    List<Job> getByParams(String keywords, String cityId, String sphereId, String typeId, String salary);
    Job update(Job job);
    Job find(Long id);
}
