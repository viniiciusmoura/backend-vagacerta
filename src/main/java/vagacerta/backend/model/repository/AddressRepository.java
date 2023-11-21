package vagacerta.backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vagacerta.backend.model.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
