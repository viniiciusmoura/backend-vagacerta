package vagacerta.backend.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import vagacerta.backend.model.entity.Address;
import vagacerta.backend.model.entity.ProfessionalExperience;
import vagacerta.backend.model.entity.User;

import java.util.Date;
import java.util.List;

@Data
public class CandidateDTO
{
    private Long id;
    private String name;
    private String cpf;
    private String generalRegister;
    private String sex;
    private Date birthdate;
    private List<Address> addresses;
    private List<ProfessionalExperience> experiences;
    CandidateDTO(){}
}
