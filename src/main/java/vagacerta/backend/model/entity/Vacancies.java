package vagacerta.backend.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Vacancies
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String office;

    @NotBlank
    private String description;

    @PositiveOrZero
    private BigDecimal salary;

    @NotNull
    private Boolean foodVoucher;

    @NotNull
    private Boolean mealVoucher;

    @NotNull
    private String formContract;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

}
