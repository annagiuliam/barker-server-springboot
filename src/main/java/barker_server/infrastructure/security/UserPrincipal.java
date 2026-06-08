package barker_server.infrastructure.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collection;
import java.util.List;

public class UserPrincipal {
  private final String userId;
  private final String username;
  private final String role;

  public UserPrincipal(String userId, String username, String role) {
    this.userId = userId;
    this.username = username;
    this.role = role;
  }

  public String getUserId() {
    return userId;
  }

  public String getUsername() {
    return username;
  }

  public String getRole() {
    return role;
  }

  // Convert role to Spring Security's GrantedAuthority format
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role));
  }

}
