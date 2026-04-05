package barker_server.application;

import java.util.List;

import org.springframework.stereotype.Service;

import barker_server.adapter.in.web.UpdateUserRequest;
import barker_server.adapter.out.UserRepository;
import barker_server.domain.in.UserUseCase;
import barker_server.domain.model.user.UserBuilder;
import barker_server.exception.UserNotFoundException;
import barker_server.domain.model.user.User;

@Service
public class UserService implements UserUseCase {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void register(String username, String password) {

    User newUser = new UserBuilder()
        .username(username)
        .password(password)
        .profilePictureUrl("url")
        .build();

    System.out.println(newUser.toString());
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
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
