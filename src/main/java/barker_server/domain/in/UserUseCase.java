package barker_server.domain.in;

import java.util.List;

import barker_server.adapter.in.web.UpdateUserRequest;
import barker_server.domain.model.user.User;

public interface UserUseCase {
  void register(String username, String password);

  User getUserById(String id);

  List<User> getAllUsers();

  User updateUser(String id, UpdateUserRequest updatedUser);

  void deleteUser(String id);
}
