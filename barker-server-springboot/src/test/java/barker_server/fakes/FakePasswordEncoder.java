package barker_server.fakes;

import barker_server.adapter.out.PasswordEncoder;

public class FakePasswordEncoder implements PasswordEncoder {
  @Override
  public String encode(String rawPassword) {
    return rawPassword;
  }

  @Override
  public boolean matches(String rawPassword, String encodedPassword) {
    return rawPassword.equals(encodedPassword);
  }
}
