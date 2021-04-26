package kz.sitedev.springmid.service.impl;
import kz.sitedev.springmid.entity.Sphere;
import kz.sitedev.springmid.entity.User;
import kz.sitedev.springmid.repository.SphereRepository;
import kz.sitedev.springmid.repository.UserRepository;
import kz.sitedev.springmid.service.SphereService;
import kz.sitedev.springmid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public List<User> getUsersByJob(Long id) {
        return userRepository.getUsersByJobId(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user =  userRepository.findByUsername(s);
        if (user == null){
            throw new UsernameNotFoundException("User: " + s + " not found");
        }
        return user;
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User update(User user){
        return userRepository.saveAndFlush(user);
    }
}
