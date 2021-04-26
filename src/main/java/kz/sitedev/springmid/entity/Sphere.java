package kz.sitedev.springmid.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "spheres")
@Setter
@Getter
@ToString(exclude = {"jobs", "userSpheres"})
public class Sphere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(mappedBy = "sphere", fetch = FetchType.LAZY)
    private List<Job> jobs;

    @OneToMany(mappedBy = "sphere", fetch = FetchType.LAZY)
    private List<UserSphere> userSpheres;

}
