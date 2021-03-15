package kz.sitedev.springmid.repository;

import kz.sitedev.springmid.entity.Sphere;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SphereRepository extends JpaRepository<Sphere, Long> {
    @Override
    List<Sphere> findAll();
}
