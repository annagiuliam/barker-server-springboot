package barker_server.adapter.in.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import barker_server.domain.in.RegisterUserUseCase;
import barker_server.domain.model.user.User;
import barker_server.exception.UserNotFoundException;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

  private final RegisterUserUseCase registerUserUseCase;

  public UserController(RegisterUserUseCase registerUserUseCase) {
    this.registerUserUseCase = registerUserUseCase;
  }

  private List<User> users = new ArrayList<>();

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.ok(users);
  }

  @PostMapping
  public ResponseEntity<Void> registerUser(@Valid @RequestBody RegisterUserRequest registeredUser) {
    // call the interface because Spring injects a concrete object that implements
    // it (RegisterUserService)
    registerUserUseCase.register(registeredUser.username(), registeredUser.password());

    return ResponseEntity.status(201).build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable String id) {
    return users.stream()
        .filter(user -> user.getId().equals(id))
        .findFirst()
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new UserNotFoundException(id));
  }

}
