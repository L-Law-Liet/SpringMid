package kz.sitedev.springmid.service;

import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.Sphere;
import kz.sitedev.springmid.entity.User;

import java.util.List;

public interface JobService {

    void create(Job job);
    List<Job> findJobsBySphereId(int sphereId);
//    List<User> getUsersByJob(Long jobId);
void delete(Long id);
}
