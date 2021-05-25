package kz.sitedev.springmid.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "types")
@Setter
@Getter
@ToString
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @OneToMany(mappedBy = "sphere", fetch = FetchType.LAZY)
//    private List<Job> jobs;

//    @OneToMany(mappedBy = "sphere", fetch = FetchType.LAZY)
//    private List<UserSphere> userSpheres;

}
