package kz.sitedev.springmid.repository;

import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findJobsBySphereId(int sphereId);

}
