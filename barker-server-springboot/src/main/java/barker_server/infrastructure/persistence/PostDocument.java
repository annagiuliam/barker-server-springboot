package barker_server.infrastructure.persistence;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import barker_server.domain.model.post.Post;

@Document(collection = "posts")
public record PostDocument(
    @Id String id,
    String userId,
    String username,
    String message,
    Instant createdAt,
    Instant updatedAt,
    List<String> images) {

  public static PostDocument fromDomain(Post post) {
    return new PostDocument(
        post.getId(),
        post.getUserId(),
        post.getUsername(),
        post.getMessage(),
        post.getCreatedAt(),
        post.getUpdatedAt(),
        post.getImages());
  }

  public static Post toDomain(PostDocument post) {
    return new Post(
        post.id(),
        post.userId(),
        post.username(),
        post.message(),
        post.createdAt(),
        post.updatedAt(),
        post.images());
  }
}
