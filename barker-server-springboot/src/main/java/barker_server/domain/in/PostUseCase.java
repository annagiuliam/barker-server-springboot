package barker_server.domain.in;

import java.util.List;

import barker_server.domain.model.post.Post;

public interface PostUseCase {
  Post addNewPost(String message, List<String> images);

  Post updatePost(Post post);

  Post deletePost(String postId);

  List<Post> getPostsByUser(String userId);

  Post getPostById(String postId);

}
