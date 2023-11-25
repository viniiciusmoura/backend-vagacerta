package vagacerta.backend.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "users")
public class User implements UserDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "email em branco")
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank(message = "password em branco")
    @Length(min = 6)
    private String password;

    @NotNull(message = "termo de serviço")
    private boolean termService;

    @NotNull(message = "termuser invalido")
    @AssertTrue(message = "termuser deve ser true")
    private boolean termUser;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Candidate candidate;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Company company;

    public User(Long id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
