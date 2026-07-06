package barker_server.domain.model.post;

import java.time.Instant;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Post {
  private String id;
  private String userId;
  private String username;

  @NotBlank(message = "Message is required")
  @Size(min = 1, max = 280, message = "Message must be between 1 and 280 characters long")
  private String message;

  private Instant createdAt;
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
