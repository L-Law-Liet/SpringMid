package kz.sitedev.springmid.service.impl;
import kz.sitedev.springmid.entity.UserSphere;
import kz.sitedev.springmid.repository.UserSphereRepository;
import kz.sitedev.springmid.service.UserSphereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSphereServiceImpl implements UserSphereService {

    @Autowired
    UserSphereRepository userSphereRepository;

    @Override
    public void create(UserSphere userSphere) {

        userSphereRepository.save(userSphere);
    }
}
