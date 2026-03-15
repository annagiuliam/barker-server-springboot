package barker_server.adapter.out;

public interface PasswordEncoder {
  String encode(String rawPassword);
}
