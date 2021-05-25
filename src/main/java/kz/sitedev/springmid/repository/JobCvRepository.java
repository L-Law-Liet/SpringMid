package kz.sitedev.springmid.repository;

import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.JobCv;
import kz.sitedev.springmid.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobCvRepository extends JpaRepository<JobCv, Long> {
    JobCv getById(Long id);
    List<JobCv> getByJobIdIn(List<Long> ids);
    List<JobCv> getByCvIdIn(List<Long> ids);
}
