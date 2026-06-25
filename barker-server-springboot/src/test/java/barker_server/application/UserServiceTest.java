package barker_server.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import barker_server.domain.model.Role;
import barker_server.domain.model.user.User;
import barker_server.exception.UserNotFoundException;
import barker_server.fakes.FakeAuthorizationHelper;
import barker_server.fakes.FakePasswordEncoder;
import barker_server.fakes.FakeUserRepository;

public class UserServiceTest {
  private UserService userService;
  private FakeUserRepository fakeRepo;
  private FakeAuthorizationHelper fakeAuthHelper;

  @BeforeEach
  void setup() {
    fakeRepo = new FakeUserRepository();
    fakeAuthHelper = new FakeAuthorizationHelper("alice-id", "alice");
    userService = new UserService(fakeRepo, new FakePasswordEncoder(), fakeAuthHelper);
  }

  @Test
  void shouldRegisterUser() {
    User saved = userService.register("john", "password123", "john@email.com", null);

    assertEquals("john", saved.getUsername());
    assertEquals("john@email.com", saved.getEmail());
  }

  @Test
  void shouldFindUserById() {
    User user = new User("1", "john", "password123", "john@email.com", Role.USER, "defaultPictureUrl");
    fakeRepo.save(user);

    User found = userService.getUserById("1");

    assertEquals("john", found.getUsername());
  }

  @Test
  void shouldThrowForMissingUser() {
    assertThrows(UserNotFoundException.class, () -> userService.getUserById("999"));
  }
}
