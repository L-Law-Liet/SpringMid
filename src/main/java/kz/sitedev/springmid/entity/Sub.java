package kz.sitedev.springmid.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name = "subs")
@Setter
@Getter
@ToString
public class Sub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int count;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "sphere_id")
    private Long sphereId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", insertable = false, updatable = false)
//    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sphere_id", insertable = false, updatable = false)
    private Sphere sphere;
}
