package barker_server.adapter.out;

import java.util.List;
import java.util.Optional;

import barker_server.domain.model.post.Post;

public interface PostRepository {
  List<Post> findAll();

  Optional<Post> findById(String id);

  Optional<Post> findByUsername(String username);

  Post save(Post post);

  void deletePost(String id);
}
