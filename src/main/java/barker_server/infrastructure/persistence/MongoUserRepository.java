package barker_server.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepository extends MongoRepository<UserDocument, String> {

  Optional<UserDocument> findByUsername(String username);

}
