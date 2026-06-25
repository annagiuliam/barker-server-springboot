package barker_server.adapter.in.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUserRequest(
        @NotBlank(message = "Username is required") @Size(min = 3, max = 20, message = "Username must be 3-20 characters long") String username,

        @NotBlank(message = "Password is required") @Size(min = 8, message = "Password must be at least 8 characters long") String password,

        @Email(message = "Email must be valid") String email,

        String profilePictureUrl) {
}
