package barker_server.application;

import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import barker_server.adapter.out.PostRepository;
import barker_server.domain.in.PostUseCase;
import barker_server.domain.model.post.Post;
import barker_server.domain.model.post.PostBuilder;
import barker_server.infrastructure.security.AuthorizationHelper;

@Service
public class PostService implements PostUseCase {

  private final PostRepository postRepository;
  private final AuthorizationHelper authHelper;

  private static final Logger log = LoggerFactory.getLogger(PostService.class);

  public PostService(PostRepository postRepository, AuthorizationHelper authHelper) {
    this.postRepository = postRepository;
    this.authHelper = authHelper;
  }

  @Override
  public Post addNewPost(String message, List<String> images) {
    String userId = authHelper.getCurrentUserId();
    String username = authHelper.getCurrentUsername();

    Post newPost = new PostBuilder()
        .userId(userId)
        .username(username)
        .createdAt(Instant.now())
        .message(message)
        .images(images)
        .build();

    return postRepository.save(newPost);
  }
}
