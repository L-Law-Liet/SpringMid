package kz.sitedev.springmid.service.impl;
import kz.sitedev.springmid.entity.Sphere;
import kz.sitedev.springmid.entity.User;
import kz.sitedev.springmid.repository.SphereRepository;
import kz.sitedev.springmid.repository.UserRepository;
import kz.sitedev.springmid.service.SphereService;
import kz.sitedev.springmid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public List<User> getUsersByJob(Long id) {
        return userRepository.getUsersByJobId(id);
    }
}
