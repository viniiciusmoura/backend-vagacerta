package vagacerta.backend.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VacanciesDTO
{
    private Long id;
    private String office;
    private String description;
    private BigDecimal salary;
    private Boolean foodVoucher;
    private Boolean mealVoucher;
    private String formContract;

    VacanciesDTO(){}
}
