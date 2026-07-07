package barker_server.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import barker_server.adapter.out.PostRepository;
import barker_server.domain.model.post.Post;

@Repository
public class PostRepositoryAdapter implements PostRepository {

  private final MongoPostRepository mongoPostRepository;

  public PostRepositoryAdapter(MongoPostRepository mongoPostRepository) {
    this.mongoPostRepository = mongoPostRepository;
  }

  @Override
  public List<Post> findAll() {
    return mongoPostRepository.findAll().stream().map(this::toDomain).toList();
  }

  @Override
  public Optional<Post> findById(String id) {
    return mongoPostRepository.findById(id).map(this::toDomain);
  }

  @Override
  public Optional<Post> findByUsername(String username) {
    return mongoPostRepository.findByUsername(username).map(this::toDomain);
  }

  @Override
  public Post save(Post post) {
    PostDocument savedPost = mongoPostRepository.save(toDocument(post));
    return toDomain(savedPost);
  }

  @Override
  public void deletePost(String id) {
    mongoPostRepository.deleteById(id);
  }

  public Post toDomain(PostDocument postDocument) {
    return new Post(postDocument.id(), postDocument.userId(), postDocument.username(), postDocument.message(),
        postDocument.createdAt(), postDocument.updatedAt(), postDocument.images());
  }

  public PostDocument toDocument(Post post) {
    return new PostDocument(post.getId(), post.getUserId(), post.getUsername(), post.getMessage(), post.getCreatedAt(),
        post.getUpdatedAt(), post.getImages());
  }
}
