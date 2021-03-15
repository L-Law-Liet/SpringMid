package kz.sitedev.springmid.repository;

import kz.sitedev.springmid.entity.UserSphere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserSphereRepository extends JpaRepository<UserSphere, Long> {

}
