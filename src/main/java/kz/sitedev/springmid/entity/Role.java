package kz.sitedev.springmid.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


//    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
//    private List<User> users;

    @Override
    public String getAuthority() {
        return name;
    }
}
