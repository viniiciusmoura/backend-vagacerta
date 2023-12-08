package vagacerta.backend.model.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vagacerta.backend.model.entity.Address;
import vagacerta.backend.model.repository.AddressRepository;
import vagacerta.backend.model.repository.AddressRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService
{
    private final AddressRepository repository;

    public List<Address> all()
    {
        return repository.findAll();
    }

    public List<Address> allCompanyId(Long id)
    {
        return repository.findByCompany_Id(id);
    }

    public List<Address> allCandidateId(Long id)
    {
        return repository.findByCandidateId(id);
    }

    public Address create(Address address)
    {
        return repository.save(address);
    }

    public Address update(Long id, Address address)
    {
        return repository.findById(id)
                .map(addr -> {
                    addr.setAddress(address.getAddress());
                    addr.setNeighborhood(address.getNeighborhood());
                    return repository.save(addr);
                }).orElse(null);
    }

    public boolean delete(Long id)
    {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
