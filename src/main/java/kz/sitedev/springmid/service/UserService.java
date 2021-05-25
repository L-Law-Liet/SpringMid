package kz.sitedev.springmid.service;

import kz.sitedev.springmid.entity.Sphere;
import kz.sitedev.springmid.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User create(User user);
    List<User> getAll();
    UserDetails loadUserByUsername(String s);
    User getByUsername(String s);
    void delete(Long id);
    User update(User user);
}
