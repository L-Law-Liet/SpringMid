package kz.sitedev.springmid.repository;

import kz.sitedev.springmid.entity.Sub;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SubRepository extends JpaRepository<Sub, Long> {
    List<Sub> getByUserId(Long id);
    @Modifying
    @Transactional
    @Query(value = "update subs set count = count + 1 where sphere_id = :id",
            nativeQuery = true)
    void event(Long id);
}
