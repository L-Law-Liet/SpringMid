package kz.sitedev.springmid.events;

import kz.sitedev.springmid.entity.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class JobEventHandler implements ApplicationListener<JobEvent> {
    @Override
    public void onApplicationEvent(JobEvent jobEvent) {
        for (User user : jobEvent.getUsers()){
            System.out.println("Notified: " + user.toString());
        }
    }
}
