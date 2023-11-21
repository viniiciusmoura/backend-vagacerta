package vagacerta.backend.model.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vagacerta.backend.model.entity.Candidate;
import vagacerta.backend.model.entity.Company;
import vagacerta.backend.model.repository.CompanyRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class CompanyService
{
    private final CompanyRepository repository;

    public List<Company> all()
    {
        return repository.findAll();
    }

    public Company create(Company company)
    {
        return repository.save(company);
    }

    public Company update(Long id, Company company)
    {
        return repository.findById(id)
                .map(c -> {
                    c.setSocialReason(company.getSocialReason());
                    c.setAreaOfActivity(company.getAreaOfActivity());
                    return repository.save(c);
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

    public List<Company> findAddressByCity(String city)
    {
        return repository.findByAddressCityContaining(city);
    }

    public List<Company> findAddressByState(String state)
    {
        return repository.findByAddressStateContaining(state);
    }

    public List<Company> findByVacanciesOffice(String office)
    {
        return repository.findByVacanciesOfficeContaining(office);
    }

}
