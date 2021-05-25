package kz.sitedev.springmid.repository;

import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findJobsBySphereId(Long sphereId);

    List<Job> getByUserId(Long userId);

    @Query(value = "select * from jobs where " +
            "(name LIKE %:keywords% " +
            "or description LIKE %:keywords% " +
            "or skills LIKE %:keywords% ) " +
            "and (:cityId = '' or city_id = :cityId) " +
            "and (:sphereId = '' or sphere_id = :sphereId) " +
            "and (:typeId = '' or type_id = :typeId) " +
            "and salary >= :salary",
            nativeQuery = true)
    List<Job> getByParams(String keywords, String cityId, String sphereId, String typeId, String salary);

    Job getById(Long id);

}
