package kz.sitedev.springmid.repository;

import kz.sitedev.springmid.entity.Cv;
import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CvRepository extends JpaRepository<Cv, Long> {
    Cv getById(Long id);
    List<Cv> getByUserId(Long id);
}
