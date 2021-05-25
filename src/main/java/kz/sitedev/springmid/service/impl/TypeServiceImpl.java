package kz.sitedev.springmid.service.impl;
import kz.sitedev.springmid.entity.Type;
import kz.sitedev.springmid.repository.TypeRepository;
import kz.sitedev.springmid.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeRepository typeRepository;

    public List<Type> all() {
        return typeRepository.findAll();
    }
}
