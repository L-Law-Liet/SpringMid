package kz.sitedev.springmid.service;

import kz.sitedev.springmid.entity.Sphere;
import kz.sitedev.springmid.entity.Sub;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubService {

    Sub create(Sub sub);
    Sub edit(Sub sub);
    void delete(Long id);
    List<Sub> getByUserId(Long id);
    List<Sub> getAll();
}
