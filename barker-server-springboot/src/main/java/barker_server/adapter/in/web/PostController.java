package barker_server.adapter.in.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import barker_server.adapter.in.web.dto.PostResponseDto;
import barker_server.domain.in.PostUseCase;
import barker_server.domain.model.post.Post;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("posts")
public class PostController {
  private final PostUseCase postUseCase;

  public PostController(PostUseCase postUseCase) {
    this.postUseCase = postUseCase;
  }

  @PostMapping("")
  public ResponseEntity<PostResponseDto> addNewPost(@Valid @RequestBody PostRequest newPost) {
    Post addedPost = postUseCase.addNewPost(newPost.message(), newPost.images());

    return ResponseEntity.ok(PostResponseDto.from(addedPost));
  }

}
