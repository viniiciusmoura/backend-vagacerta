package vagacerta.backend.model.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vagacerta.backend.model.entity.Candidate;
import vagacerta.backend.model.entity.User;
import vagacerta.backend.model.repository.CandidateRepository;
import vagacerta.backend.model.repository.UserRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CandidateService
{
    private final CandidateRepository repository;

    public List<Candidate> all()
    {
        return repository.findAll();
    }

    public Candidate create(Candidate candidate)
    {
        return repository.save(candidate);
    }

    public Candidate update(Long id, Candidate candidate)
    {
        return repository.findById(id)
                            .map(c -> {
                                c.setName(candidate.getName());
                                c.setBirthdate(candidate.getBirthdate());
                                c.setSex(candidate.getSex());
                                c.setGeneralRegister(candidate.getGeneralRegister());
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

    public List<Candidate> findAddressByCity(String city)
    {
        return repository.findByAddressCityContaining(city);
    }

    public List<Candidate> findAddressByState(String state)
    {
        return repository.findByAddressStateContaining(state);
    }

    public List<Candidate> findByProfessionalExperienceOffice(String office)
    {
        return repository.findByProfessionalExperienceOfficeContaining(office);
    }

}
