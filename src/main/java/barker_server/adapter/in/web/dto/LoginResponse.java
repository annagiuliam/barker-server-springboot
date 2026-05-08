package barker_server.adapter.in.web.dto;

public record LoginResponse(
    String token, UserResponseDto user) {

}
