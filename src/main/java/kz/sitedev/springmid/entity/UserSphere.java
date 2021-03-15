package kz.sitedev.springmid.entity;

import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name = "users_spheres")
public class UserSphere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int sphereId;
    private int userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSphereId() {
        return sphereId;
    }

    public void setSphereId(int sphereId) {
        this.sphereId = sphereId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
