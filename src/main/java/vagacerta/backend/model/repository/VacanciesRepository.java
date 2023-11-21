package vagacerta.backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vagacerta.backend.model.entity.Company;
import vagacerta.backend.model.entity.Vacancies;

import java.math.BigDecimal;
import java.util.List;

public interface VacanciesRepository extends JpaRepository<Vacancies, Long>
{
    List<Vacancies> findByOfficeIsLike(String office);

    List<Vacancies> findBySalaryGreaterThan(BigDecimal salary);

}
