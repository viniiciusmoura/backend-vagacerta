package vagacerta.backend.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Candidate
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Length(min = 3)
    private String name;

    @NotBlank
    @CPF
    @Column(unique = true)
    private String cpf;

    @NotBlank
    @Length(min = 6)
    @Column(unique = true)
    private String generalRegister;

    @NotBlank
    private String sex;

    @PastOrPresent
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @OneToOne
    @JoinColumn( name = "user_id")
    private User user;

    @OneToMany( mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<ProfessionalExperience> experiences;

    @OneToMany( mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Candidate(Long id) {
        this.id = id;
    }
}
