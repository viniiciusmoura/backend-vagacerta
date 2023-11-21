package vagacerta.backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import vagacerta.backend.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long>
{
    UserDetails findByEmail(String email);

}
