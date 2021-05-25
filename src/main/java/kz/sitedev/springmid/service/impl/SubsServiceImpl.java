package kz.sitedev.springmid.service.impl;
import kz.sitedev.springmid.entity.Sub;
import kz.sitedev.springmid.repository.SubRepository;
import kz.sitedev.springmid.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubsServiceImpl implements SubService {
    @Autowired
    SubRepository subRepository;

    @Override
    public Sub create(Sub sub) {
        return subRepository.saveAndFlush(sub);
    }

    @Override
    public Sub edit(Sub sub) {
        return subRepository.saveAndFlush(sub);
    }

    @Override
    public void delete(Long id) {
        subRepository.deleteById(id);
    }

    @Override
    public List<Sub> getByUserId(Long id) {
        return subRepository.getByUserId(id);
    }

    @Override
    public List<Sub> getAll() {
        return subRepository.findAll();
    }
}
