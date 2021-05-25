package kz.sitedev.springmid.events;

import kz.sitedev.springmid.entity.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.ArrayList;
import java.util.List;
@Getter
public class JobEvent extends ApplicationEvent {
    private Long id;
    public JobEvent(Object source, Long id) {
        super(source);
        this.id = id;
    }
}
