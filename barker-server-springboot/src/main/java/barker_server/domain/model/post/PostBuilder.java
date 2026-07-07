package barker_server.domain.model.post;

import java.time.Instant;
import java.util.List;

public class PostBuilder {
  private String id;
  private String userId;
  private String username;

  private String message;

  private Instant createdAt;
  private Instant updatedAt;
  private List<String> images;

  public PostBuilder id(String id) {
    this.id = id;
    return this;
  }

  public PostBuilder userId(String userId) {
    this.userId = userId;
    return this;
  }

  public PostBuilder username(String username) {
    this.username = username;
    return this;
  }

  public PostBuilder message(String message) {
    this.message = message;
    return this;
  }

  public PostBuilder createdAt(Instant createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public PostBuilder updatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  public PostBuilder images(List<String> images) {
    this.images = images;
    return this;
  }

  public Post build() {

    if (userId == null || userId.isBlank()) {
      throw new IllegalStateException("user id is required");
    }

    if (message == null || message.isBlank()) {
      throw new IllegalStateException("message is required");
    }

    if (message.length() > 200) {
      throw new IllegalArgumentException("message is too long");
    }

    return new Post(id, userId, username, message, createdAt, updatedAt, images);
  }
}
