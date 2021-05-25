package kz.sitedev.springmid.events;

import kz.sitedev.springmid.entity.User;
import kz.sitedev.springmid.repository.SubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class JobEventHandler implements ApplicationListener<JobEvent> {
    @Autowired
    SubRepository subRepository;

    @Override
    public void onApplicationEvent(JobEvent jobEvent) {
        subRepository.event(jobEvent.getId());
    }
}
