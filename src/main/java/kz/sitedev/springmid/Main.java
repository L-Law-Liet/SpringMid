package kz.sitedev.springmid;

import kz.sitedev.springmid.config.Config;
import kz.sitedev.springmid.entity.Job;
import kz.sitedev.springmid.entity.Sphere;
import kz.sitedev.springmid.entity.User;
import kz.sitedev.springmid.entity.UserSphere;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        HuntSystem hs = context.getBean("huntSystem", HuntSystem.class);
        Scanner L = new Scanner(System.in);

        int ch = -1;
        List<Sphere> spheres;
        List<Job> jobs;
        Job newJob;
        UserSphere subscriber;

        while (ch != 0){
            System.out.println("1.List of Spheres");
            System.out.println("2.List of Users");
            System.out.println("3.Get Jobs by Sphere");
            System.out.println("4.Create Job");
            System.out.println("5.Delete Job");
            System.out.println("6.Subscribe User to Sphere");
            System.out.println("0.Exit");
            ch = L.nextInt();

            switch (ch){
                case 1:
                    spheres = hs.getSpheres(context);
                    System.out.println("===============================================");
                    for (Sphere sphere : spheres) {
                        System.out.println(sphere.toString());
                    }
                    System.out.println("===============================================");
                    break;
                case 2:
                    List<User> users = hs.getUsers(context);
                    System.out.println("===============================================");
                    for (User user : users) {
                        System.out.println(user.toString());
                    }
                    System.out.println("===============================================");
                    break;
                case 3:
                    spheres = hs.getSpheres(context);
                    for (Sphere sphere : spheres) {
                        System.out.println(sphere.getId() + "."+sphere.getTitle());
                    }
                    System.out.println("Which Sphere:");
                    int sphereid = L.nextInt();
                    jobs = hs.getJobsBySphere(context, sphereid);
                    System.out.println("===============================================");
                    for (Job job : jobs){
                        System.out.println(job.toString());
                    }
                    System.out.println("===============================================");
                    break;
                case 4:
                    newJob = new Job();
                    System.out.println("Title:");
                    newJob.setTitle(L.next());
                    System.out.println("Salary:");
                    newJob.setSalary(L.nextInt());
                    spheres = hs.getSpheres(context);
                    for (Sphere sphere : spheres) {
                        System.out.println(sphere.getId() + "."+sphere.getTitle());
                    }
                    System.out.println("Sphere:");
                    newJob.setSphereId(L.nextInt());
                    hs.createJob(context, newJob);
                    break;
                case 5:
                    System.out.println("ID:");
                    Long id = L.nextLong();
                    hs.deleteJob(context, id);
                    break;
                case 6:
                    subscriber = new UserSphere();
                    users = hs.getUsers(context);
                    for (User user : users) {
                        System.out.println(user.getId() + "."+user.getName());
                    }
                    System.out.println("User:");
                    subscriber.setUserId(L.nextInt());
                    spheres = hs.getSpheres(context);
                    for (Sphere sphere : spheres) {
                        System.out.println(sphere.getId() + "."+sphere.getTitle());
                    }
                    System.out.println("Sphere:");
                    subscriber.setSphereId(L.nextInt());
                    hs.subscribeUserToSphere(context, subscriber);
                    break;
            }
        }
    }
}
