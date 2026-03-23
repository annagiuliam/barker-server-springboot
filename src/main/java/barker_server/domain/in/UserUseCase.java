package barker_server.domain.in;

import java.util.List;

import barker_server.domain.model.user.User;

public interface UserUseCase {
  void register(String username, String password);

  List<User> getAllUsers();
}
