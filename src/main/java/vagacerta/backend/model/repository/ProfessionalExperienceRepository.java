package vagacerta.backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vagacerta.backend.model.entity.ProfessionalExperience;

import java.util.List;

public interface ProfessionalExperienceRepository extends JpaRepository<ProfessionalExperience, Long> {
}
