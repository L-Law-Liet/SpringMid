package kz.sitedev.springmid.repository;

import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.Sphere;
import kz.sitedev.springmid.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    @Query(value = "select u.id, u.name, u.age from jobs j " +
            "join users_spheres us using(sphere_id) " +
            "join users u on u.id = us.user_id " +
            "where j.id = :id", nativeQuery = true)
    List<User> getUsersByJobId(Long id);
}
