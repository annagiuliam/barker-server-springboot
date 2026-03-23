package barker_server.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepository extends MongoRepository<UserDocument, String> {

}
