package vagacerta.backend.model.response;

import lombok.Data;

@Data
public class AddressDTO
{
    private Long id;
    private String cep;
    private String address;
    private String neighborhood;
    private String state;
    private String city;
}
