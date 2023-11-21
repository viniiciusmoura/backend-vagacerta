package vagacerta.backend.model.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vagacerta.backend.model.entity.User;
import vagacerta.backend.model.repository.UserRepository;

@AllArgsConstructor
@Service
public class UserService
{

    private final UserRepository repository;

    public User create(User user)
    {
        return repository.save(cryptPassword(user));
    }//Create user

    public UserDetails findByEmail(String email)
    {
        return repository.findByEmail(email);
    }

    private User cryptPassword(User user)
    {
        var passwordEncoder = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(passwordEncoder);
        return user;
    }
}
