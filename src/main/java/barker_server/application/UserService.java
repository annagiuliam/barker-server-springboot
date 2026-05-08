package barker_server.application;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import barker_server.adapter.in.web.UpdateUserRequest;
import barker_server.adapter.out.UserRepository;
import barker_server.domain.in.UserUseCase;
import barker_server.domain.model.user.UserBuilder;
import barker_server.exception.UserNotFoundException;
import barker_server.domain.model.user.User;
import barker_server.adapter.out.PasswordEncoder;

@Service
public class UserService implements UserUseCase {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private static final Logger log = LoggerFactory.getLogger(UserService.class);

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User register(String username, String password, String email, String profilePictureUrl) {

    User newUser = new UserBuilder()
        .username(username)
        .password(passwordEncoder.encode(password))
        .email(email)
        .profilePictureUrl(profilePictureUrl)
        .build();

    User registeredUser = userRepository.save(newUser);

    log.info("Registered user: {}", newUser.getUsername());
    log.info("Built user email: {}", newUser.getEmail());

    return registeredUser;
  }

  @Override
  public User getUserById(String id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException(id));
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public void deleteUser(String id) {
    userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException(id));

    userRepository.deleteUser(id);
  }

  @Override
  public User updateUser(String id, UpdateUserRequest updatedUser) {
    User existingUser = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException(id));
    User userToUpdate = mergeUser(existingUser, updatedUser);
    return userRepository.updateUser(userToUpdate);
  }

  private User mergeUser(User existingUser, UpdateUserRequest updatedUser) {
    String username = isBlank(updatedUser.username()) ? existingUser.getUsername() : updatedUser.username();
    String password = isBlank(updatedUser.password()) ? existingUser.getPassword() : updatedUser.password();
    String email = isBlank(updatedUser.email()) ? existingUser.getEmail() : updatedUser.email();
    String pictureUrl = isBlank(updatedUser.profilePictureUrl()) ? existingUser.getProfilePictureUrl()
        : updatedUser.profilePictureUrl();

    return new User(existingUser.getId(), username, password, email, existingUser.getRole(), pictureUrl);
  }

  private boolean isBlank(String value) {
    return value == null || value.isBlank();
  }

}
