package barker_server.adapter.out;

import java.util.List;
import java.util.Optional;

import barker_server.domain.model.user.User;

public interface UserRepository {
  List<User> findAll();

  Optional<User> findById(String id);

  User save(User user);

  User updateUser(User user);

  void deleteUser(String id);
}
