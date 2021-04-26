package kz.sitedev.springmid.service;

import kz.sitedev.springmid.entity.Sphere;
import kz.sitedev.springmid.entity.User;

import java.util.List;

public interface UserService {

    User create(User user);
    List<User> getAll();
    List<User> getUsersByJob(Long jobId);
    void delete(Long id);
    User update(User user);
}
