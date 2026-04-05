package barker_server.adapter.in.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUserRequest(
    @NotBlank @Size(min = 3, max = 20, message = "Username must be 3-20 characters long") String username,

    @NotBlank @Size(min = 8) String password) {
}
