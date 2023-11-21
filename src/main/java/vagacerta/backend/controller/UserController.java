package vagacerta.backend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vagacerta.backend.model.entity.User;
import vagacerta.backend.model.service.UserService;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController
{

    private final UserService service;

    @PostMapping("save")
    public ResponseEntity<User> save(@Valid @RequestBody User user)
    {
        return new ResponseEntity<User>(service.create(user), HttpStatus.CREATED);
    } //Create User

    @GetMapping("email/{email}")
    public ResponseEntity<?> findEmail(@PathVariable String email)
    {
        return new ResponseEntity<>(service.findByEmail(email), HttpStatus.OK);
    }
}
