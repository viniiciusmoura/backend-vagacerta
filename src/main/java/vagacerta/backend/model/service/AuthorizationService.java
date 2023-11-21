package vagacerta.backend.model.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vagacerta.backend.model.repository.UserRepository;

@Service
@AllArgsConstructor
public class AuthorizationService implements UserDetailsService {

    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return repository.findByEmail(username);
    }
}