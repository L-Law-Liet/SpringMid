package kz.sitedev.springmid.events;

import kz.sitedev.springmid.entity.User;
import org.springframework.context.ApplicationEvent;

import java.util.ArrayList;
import java.util.List;

public class JobEvent extends ApplicationEvent {
    private List<User> users = new ArrayList<>();
    public JobEvent(Object source, List<User> users) {
        super(source);
        this.users = users;
    }

    public List<User> getUsers(){
        return this.users;
    }
}
