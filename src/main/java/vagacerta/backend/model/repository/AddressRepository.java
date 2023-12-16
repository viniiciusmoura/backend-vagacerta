package vagacerta.backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import vagacerta.backend.model.entity.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long>
{
    List<Address> findByCompany_Id(Long id);

    List<Address> findByCandidateId(Long id);

    @Query("SELECT DISTINCT a.state FROM Address a")
    List<String> getAddressState();
}
