package barker_server.adapter.out;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptEncoderAdapter implements PasswordEncoder {
  private final BCryptPasswordEncoder passwordEncoder;

  public BCryptEncoderAdapter(BCryptPasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public String encode(String rawPassword) {
    return passwordEncoder.encode(rawPassword);
  }

  @Override
  public boolean matches(String rawPassword, String encodedPassword) {
    return passwordEncoder.matches(rawPassword, encodedPassword);
  }
}
