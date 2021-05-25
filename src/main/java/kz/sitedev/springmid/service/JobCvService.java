package kz.sitedev.springmid.service;

import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.JobCv;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobCvService {

    JobCv get(Long id);
    List<JobCv> all();
    List<JobCv> getByJobIds(List<Long> ids);
    List<JobCv> getByCvIds(List<Long> ids);
    JobCv create(JobCv jobCv);
    JobCv edit(JobCv jobCv);
}
