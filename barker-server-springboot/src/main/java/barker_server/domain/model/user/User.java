package barker_server.domain.model.user;

import java.util.Objects;
import barker_server.domain.model.Role;
import jakarta.validation.constraints.*;

public class User {
  private String id;

  @NotBlank(message = "Username is required")
  @Size(min = 3, max = 20, message = "Username must be 3-20 characters long")
  private final String username;

  @NotBlank(message = "Password is required")
  @Size(min = 8, message = "Password must be at least 8 characters long")
  private String password;

  @Email(message = "Email must be valid")
  private String email;

  private Role role;
  private String profilePictureUrl;

  // Builder pattern, to practice
  User(UserBuilder builder) {
    this.id = builder.getId();
    this.username = builder.getUsername();
    this.password = builder.getPassword();
    this.email = builder.getEmail();
    this.role = builder.getRole();
    this.profilePictureUrl = builder.getProfilePictureUrl();
  }

  public User(String id, String username, String password, String email, Role role, String profilePictureUrl) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.role = role == null ? Role.USER : role;
    this.profilePictureUrl = profilePictureUrl;
  }

  public String getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public Role getRole() {
    return role;
  }

  public String getEmail() {
    return email;
  }

  public String getProfilePictureUrl() {
    return profilePictureUrl;
  }

  public void setProfilePuctureUrl(String url) {
    this.profilePictureUrl = url;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    User user = (User) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Username: " + username;
  }

}
