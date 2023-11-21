package vagacerta.backend.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class ProfessionalExperience
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Length(min = 3)
    private String company;

    @NotBlank
    private String office;

    @NotBlank
    private String description;

    @PastOrPresent
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @PastOrPresent
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}
