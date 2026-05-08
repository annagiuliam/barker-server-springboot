package barker_server.adapter.in.web.dto;

import barker_server.domain.model.Role;
import barker_server.domain.model.user.User;

public record UserResponseDto(
        String id,
        String username,
        String email,
        Role role,
        String profilePictureurl) {

    public static UserResponseDto from(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole(),
                user.getProfilePictureUrl());
    }

}
