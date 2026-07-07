package barker_server.adapter.in.web;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PostRequest(
        @NotBlank(message = "Post content is required") @Size(min = 1, max = 200, message = "Post content must be 1-200 characters long") String message,
        List<String> images) {
}
