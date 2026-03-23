package barker_server.application;

import java.util.List;

import org.springframework.stereotype.Service;

import barker_server.adapter.out.UserRepository;
import barker_server.domain.in.UserUseCase;
import barker_server.domain.model.user.UserBuilder;
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

}
