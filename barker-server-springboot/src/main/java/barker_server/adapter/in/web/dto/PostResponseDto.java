package barker_server.adapter.in.web.dto;

import java.time.Instant;
import java.util.List;

import barker_server.domain.model.post.Post;

public record PostResponseDto(
    String id,
    String userId,
    String username,
    String message,
    Instant createdAt,
    Instant updatedAt,
    List<String> images

) {
  public static PostResponseDto from(Post post) {
    return new PostResponseDto(
        post.getId(),
        post.getUserId(),
        post.getUsername(),
        post.getMessage(),
        post.getCreatedAt(),
        post.getUpdatedAt(),
        post.getImages());
  }
}
