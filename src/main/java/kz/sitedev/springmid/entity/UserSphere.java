package kz.sitedev.springmid.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name = "users_spheres")
@Setter
@Getter
@ToString
public class UserSphere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sphere_id")
    private Long sphereId;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sphere_id", insertable = false, updatable = false)
    private Sphere sphere;
}
