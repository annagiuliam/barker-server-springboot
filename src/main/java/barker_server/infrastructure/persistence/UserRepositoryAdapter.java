package barker_server.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

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

  @Override
  public User save(User user) {
    UserDocument savedUser = mongoUserRepository.save(toDocument(user));
    return this.toDomain(savedUser);
  }

  @Override
  public Optional<User> findById(String id) {
    return mongoUserRepository.findById(id)
        .map(this::toDomain);
  }

  @Override
  public Optional<User> findByUsername(String username) {
    return mongoUserRepository.findByUsername(username)
        .map(this::toDomain);
  }

  @Override
  public User updateUser(User user) {
    UserDocument updatedUser = mongoUserRepository.save(toDocument(user));
    return this.toDomain(updatedUser);
  }

  @Override
  public void deleteUser(String id) {
    mongoUserRepository.deleteById(id);
  }

  public User toDomain(UserDocument userDocument) {
    return new User(
        userDocument.getId(),
        userDocument.getUsername(),
        userDocument.getPassword(),
        userDocument.getEmail(),
        userDocument.getRole(),
        userDocument.getProfilePictureUrl());
  }

  public UserDocument toDocument(User user) {
    return new UserDocument(
        user.getId(),
        user.getUsername(),
        user.getPassword(),
        user.getRole(),
        user.getEmail(),
        user.getProfilePictureUrl());
  }

}
