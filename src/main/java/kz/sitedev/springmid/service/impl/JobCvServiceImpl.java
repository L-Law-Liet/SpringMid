package kz.sitedev.springmid.service.impl;
import kz.sitedev.springmid.entity.JobCv;
import kz.sitedev.springmid.repository.JobCvRepository;
import kz.sitedev.springmid.service.JobCvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobCvServiceImpl implements JobCvService {

    @Autowired
    JobCvRepository jobCvRepository;

    public List<JobCv> all() {
        return jobCvRepository.findAll();
    }

    public JobCv get(Long id){
        return jobCvRepository.getById(id);
    }

    public List<JobCv> getByJobIds(List<Long> ids){
        return jobCvRepository.getByJobIdIn(ids);
    }

    public List<JobCv> getByCvIds(List<Long> ids){
        return jobCvRepository.getByCvIdIn(ids);
    }

    public JobCv create(JobCv jobCv){
        return jobCvRepository.saveAndFlush(jobCv);
    }
    public JobCv edit(JobCv jobCv){
        return jobCvRepository.saveAndFlush(jobCv);
    }
}
