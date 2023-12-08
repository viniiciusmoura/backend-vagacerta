package vagacerta.backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vagacerta.backend.model.entity.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long>
{
    List<Address> findByCompany_Id(Long id);

    List<Address> findByCandidateId(Long id);
}
