package barker_server.adapter.in.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import barker_server.domain.in.UserUseCase;
import barker_server.domain.model.user.User;
import barker_server.infrastructure.security.JwtUtil;
import jakarta.validation.Valid;
import barker_server.adapter.in.web.dto.LoginResponse;
import barker_server.adapter.in.web.dto.UserResponseDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/auth")
public class AuthController {
  private final UserUseCase userUseCase;
  private final JwtUtil jwtUtil;

  public AuthController(UserUseCase userUseCase, JwtUtil jwtUtil) {
    this.userUseCase = userUseCase;
    this.jwtUtil = jwtUtil;
  }

  @PostMapping
  public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest credentials) {
    User loggedInUser = userUseCase.login(credentials.username(), credentials.password());

    UserResponseDto userDto = UserResponseDto.from(loggedInUser);
    String token = jwtUtil.generateToken(loggedInUser.getUsername());

    System.out.println(credentials.toString());
    return ResponseEntity.ok(new LoginResponse(token, userDto));
  }

}
