package kz.sitedev.springmid.entity;

import javax.persistence.*;

@Entity
@Table(name = "spheres")
public class Sphere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
