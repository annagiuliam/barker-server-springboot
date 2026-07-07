package barker_server.domain.model.post;

import java.time.Instant;
import java.util.List;

public class Post {
  private String id;
  private String userId;
  private String username;

  private String message;

  private final Instant createdAt;
  private Instant updatedAt;
  private List<String> images;

  public Post(String id, String userId, String username, String message, Instant createdAt, Instant updatedAt,
      List<String> images) {
    this.id = id;
    this.userId = userId;
    this.username = username;
    this.message = message;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.images = images;
  }

  public String getId() {
    return id;
  }

  public String getUserId() {
    return userId;
  }

  public String getUsername() {
    return username;
  }

  public String getMessage() {
    return message;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public List<String> getImages() {
    return images;
  }

}
