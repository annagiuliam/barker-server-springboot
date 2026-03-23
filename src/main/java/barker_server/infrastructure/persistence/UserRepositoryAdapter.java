package barker_server.infrastructure.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import barker_server.adapter.out.UserRepository;
import barker_server.domain.model.user.User;

@Repository
public class UserRepositoryAdapter implements UserRepository {

  private final MongoUserRepository mongoUserRepository;

  public UserRepositoryAdapter(MongoUserRepository mongoUserRepository) {
    this.mongoUserRepository = mongoUserRepository;
  }

  @Override
  public List<User> findAll() {
    return mongoUserRepository.findAll()
        .stream()
        .map(this::toDomain)
        .toList();
  }

  public User toDomain(UserDocument userDocument) {
    return new User(userDocument.getId(), userDocument.getUsername(), userDocument.getPassword(),
        userDocument.getEmail(), userDocument.getRole(), userDocument.getProfilePictureUrl());
  }

}
