package kz.sitedev.springmid;

import kz.sitedev.springmid.controller.JobsController;
import kz.sitedev.springmid.controller.SpheresController;
import kz.sitedev.springmid.controller.UserSpheresController;
import kz.sitedev.springmid.controller.UsersController;
import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.Sphere;
import kz.sitedev.springmid.entity.User;
import kz.sitedev.springmid.entity.UserSphere;
import kz.sitedev.springmid.events.JobEvent;
import kz.sitedev.springmid.events.JobEventHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HuntSystem {
    public List<Sphere> getSpheres(AnnotationConfigApplicationContext context){
        SpheresController spheresController = context.getBean("spheresController", SpheresController.class);
        return spheresController.all();
    }
    public List<User> getUsers(AnnotationConfigApplicationContext context){
        UsersController usersController = context.getBean("usersController", UsersController.class);
        return usersController.all();
    }
    public List<Job> getJobsBySphere(AnnotationConfigApplicationContext context, int sphereId){
        JobsController jobsController = context.getBean("jobsController", JobsController.class);
        return jobsController.findJobsBySphereId(sphereId);
    }
    public void createJob(AnnotationConfigApplicationContext context, Job job){
        JobsController jobsController = context.getBean("jobsController", JobsController.class);
        jobsController.create(job);
        UsersController usersController = context.getBean("usersController", UsersController.class);
        List <User> users = usersController.getUsersByJob(job.getId());
        System.out.println("Created");
        context.getBean("jobEventHandler", JobEventHandler.class)
                .onApplicationEvent(
                        new JobEvent(this, users)
                );
    }
    public void deleteJob(AnnotationConfigApplicationContext context, Long id){
        JobsController jobsController = context.getBean("jobsController", JobsController.class);
        jobsController.delete(id);
        UsersController usersController = context.getBean("usersController", UsersController.class);
        List <User> users = usersController.getUsersByJob(id);
        System.out.println("Deleted");
        context.getBean("jobEventHandler", JobEventHandler.class)
                .onApplicationEvent(
                        new JobEvent(this, users)
                );
    }
    public void subscribeUserToSphere(AnnotationConfigApplicationContext context, UserSphere userSphere){
        UserSpheresController userSpheresController = context.getBean("userSpheresController", UserSpheresController.class);
        userSpheresController.create(userSphere);
        System.out.println("Subscribed");
    }
}
