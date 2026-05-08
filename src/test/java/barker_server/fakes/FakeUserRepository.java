package barker_server.fakes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import barker_server.adapter.out.UserRepository;
import barker_server.domain.model.user.User;

public class FakeUserRepository implements UserRepository {
  private final Map<String, User> storage = new HashMap<>();

  @Override
  public User save(User user) {
    storage.put(user.getId(), user);
    return user;
  }

  @Override
  public Optional<User> findById(String id) {
    return Optional.ofNullable(storage.get(id));
  }

  @Override
  public User updateUser(User user) {
    storage.put(user.getId(), user);
    return user;
  }

  @Override
  public List<User> findAll() {
    return new ArrayList<>(storage.values());
  }

  @Override
  public void deleteUser(String id) {
    storage.remove(id);
  }

}
