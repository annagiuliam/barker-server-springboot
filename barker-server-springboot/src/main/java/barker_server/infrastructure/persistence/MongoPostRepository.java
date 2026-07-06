package barker_server.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoPostRepository extends MongoRepository<PostDocument, String> {

  Optional<PostDocument> findByUsername(String username);
}
