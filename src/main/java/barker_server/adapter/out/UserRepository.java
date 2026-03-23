package barker_server.adapter.out;

import java.util.List;

import barker_server.domain.model.user.User;

public interface UserRepository {
  List<User> findAll();
}
