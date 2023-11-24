package pl.coderslab.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.model.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Email
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> role = new ArrayList<>();
}
