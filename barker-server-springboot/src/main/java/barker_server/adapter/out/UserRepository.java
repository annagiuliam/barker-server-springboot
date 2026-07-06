package barker_server.adapter.out;

import java.util.List;
import java.util.Optional;

import barker_server.domain.model.user.User;

public interface UserRepository {
  List<User> findAll();

  Optional<User> findById(String id);

  Optional<User> findByUsername(String username);

  User save(User user);

  void deleteUser(String id);
}
