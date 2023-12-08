package vagacerta.backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vagacerta.backend.model.entity.Candidate;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long>
{
    @Query("SELECT c FROM Candidate c " +
            "INNER JOIN ProfessionalExperience pe ON c.id = pe.candidate.id " +
            "WHERE pe.office LIKE %:office%")
    List<Candidate> findByProfessionalExperienceOfficeContaining(String office);

    @Query("SELECT c FROM Candidate c " +
            "INNER JOIN Address addr ON c.id = addr.candidate.id " +
            "WHERE addr.city LIKE %:city%")
    List<Candidate> findByAddressCityContaining(String city);

    @Query("SELECT c FROM Candidate c " +
            "INNER JOIN Address addr ON c.id = addr.candidate.id " +
            "WHERE addr.state LIKE %:state%")
    List<Candidate> findByAddressStateContaining(String state);

    Candidate findByUserId(Long id);
}
