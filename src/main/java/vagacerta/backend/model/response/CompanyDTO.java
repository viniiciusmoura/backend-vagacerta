package vagacerta.backend.model.response;

import lombok.Data;
import vagacerta.backend.model.entity.Address;
import vagacerta.backend.model.entity.Vacancies;

import java.util.List;

@Data
public class CompanyDTO
{
    private Long id;
    private String socialReason;
    private String cnpj;
    private String areaOfActivity;
    private List<Vacancies> vacancies;
    private List<Address> addresses;
}
