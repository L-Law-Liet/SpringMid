package kz.sitedev.springmid.repository;

import kz.sitedev.springmid.entity.Message;
import kz.sitedev.springmid.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> getByJobCvId(Long id);
}
