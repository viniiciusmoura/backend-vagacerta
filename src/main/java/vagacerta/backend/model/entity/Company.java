package vagacerta.backend.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Company
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Length(min = 3)
    private String socialReason;

    @CNPJ
    @NotBlank
    @Column(unique = true)
    private String cnpj;

    @NotBlank
    @Length(min = 3)
    private String areaOfActivity;

    @OneToOne
    @JoinColumn( name = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany( mappedBy = "company", cascade = CascadeType.ALL)
    private List<Vacancies> vacancies;

    @JsonIgnore
    @OneToMany( mappedBy = "company", cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Company(Long id) {
        this.id = id;
    }
}
