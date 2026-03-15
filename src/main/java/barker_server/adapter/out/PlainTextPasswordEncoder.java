package barker_server.adapter.out;

public class PlainTextPasswordEncoder implements PasswordEncoder {
  @Override
  public String encode(String rawPassword) {
    return rawPassword;
  }
}