package kz.sitedev.springmid.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "jobs")
@Setter
@Getter
@ToString
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int salary;

    @Column(name = "sphere_id")
    private Long sphereId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sphere_id", insertable = false, updatable = false)
    private Sphere sphere;
}
