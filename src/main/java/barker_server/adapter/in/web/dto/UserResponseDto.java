package barker_server.adapter.in.web.dto;

import barker_server.domain.model.Role;

public record UserResponseDto(
    String id,
    String username,
    String email,
    Role role,
    String profilePictureurl) {

}
