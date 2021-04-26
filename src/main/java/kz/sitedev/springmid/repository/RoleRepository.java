package kz.sitedev.springmid.repository;

import kz.sitedev.springmid.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findFirstByName(String s);
}
