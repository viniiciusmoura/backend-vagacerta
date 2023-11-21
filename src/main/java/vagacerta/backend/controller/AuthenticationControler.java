package vagacerta.backend.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vagacerta.backend.model.entity.User;
import vagacerta.backend.model.entity.records.AuthenticationDTO;
import vagacerta.backend.model.entity.records.LoginResponse;
import vagacerta.backend.security.TokenService;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthenticationControler
{
    private AuthenticationManager authenticationManager;

    private final TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data)
    {
        var userEmailPassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(userEmailPassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponse(token));

    }
}
