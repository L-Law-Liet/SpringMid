package kz.sitedev.springmid.service;

import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {

    List<Type> all();
}
