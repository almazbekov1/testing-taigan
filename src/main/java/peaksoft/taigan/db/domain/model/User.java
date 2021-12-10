package peaksoft.taigan.db.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
//@MappedSuperclass
@Entity(name = "users")
//@Table
@Inheritance
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;


}
