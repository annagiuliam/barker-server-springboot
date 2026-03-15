package barker_server.adapter.in.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUserRequest(@NotBlank String username, @NotBlank @Size(min = 8) String password) {
}
