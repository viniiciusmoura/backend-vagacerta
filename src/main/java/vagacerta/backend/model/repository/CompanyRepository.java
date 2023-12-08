package vagacerta.backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vagacerta.backend.model.entity.Address;
import vagacerta.backend.model.entity.Candidate;
import vagacerta.backend.model.entity.Company;
import vagacerta.backend.model.entity.Vacancies;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long>
{
        List<Company> findBySocialReasonLikeOrAreaOfActivityLike(String socialReason, String areaActivity);

        @Query("SELECT c FROM Company c " +
                "INNER JOIN Address addr ON c.id = addr.company.id " +
                "WHERE addr.city LIKE %:city%")
        List<Company> findByAddressCityContaining(String city);

        @Query("SELECT c FROM Company c " +
                "INNER JOIN Address addr ON c.id = addr.company.id " +
                "WHERE addr.state LIKE %:state%")
        List<Company> findByAddressStateContaining(String state);

        @Query("SELECT c FROM Company c " +
                "INNER JOIN Vacancies v ON c.id = v.company.id " +
                "WHERE v.office LIKE %:office%")
        List<Company> findByVacanciesOfficeContaining(String office);

        Company findByUserId(Long id);
}
