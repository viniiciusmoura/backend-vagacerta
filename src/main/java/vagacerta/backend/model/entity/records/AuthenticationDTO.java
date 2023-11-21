package vagacerta.backend.model.entity.records;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record AuthenticationDTO(
        @NotBlank @Email String email,
        @NotBlank @Length(min = 6) String password)
{
}
