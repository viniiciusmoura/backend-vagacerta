package vagacerta.backend.model.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vagacerta.backend.model.entity.Vacancies;
import vagacerta.backend.model.repository.VacanciesRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class VacanciesService
{
    private final VacanciesRepository repository;

    public List<Vacancies> all()
    {
        return repository.findAll();
    }

    public List<Vacancies> allCompanyId(Long id)
    {
        return repository.findByCompanyId(id);
    }

    public Vacancies createOrUpdate(Vacancies vocancies)
    {
        return repository.save(vocancies);
    }

    public boolean delete(Long id)
    {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Vacancies> findOffice(String office)
    {
        return repository.findByOfficeIsLike(office);
    }

    public List<Vacancies> findBySalaryGreaterThan(BigDecimal salary)
    {
        return repository.findBySalaryGreaterThan(salary);
    }
}
