package vagacerta.backend.model.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vagacerta.backend.model.entity.ProfessionalExperience;
import vagacerta.backend.model.repository.ProfessionalExperienceRepository;


import java.util.List;

@Service
@AllArgsConstructor
public class ProfessionalExperienceService
{
    private final ProfessionalExperienceRepository repository;

    public List<ProfessionalExperience> all()
    {
        return repository.findAll();
    }

    public ProfessionalExperience createOrUpdate(ProfessionalExperience experience)
    {
        return repository.save(experience);
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
