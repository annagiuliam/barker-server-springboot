package barker_server.domain.model.user;

import barker_server.domain.model.Role;

public class UserBuilder {
  private String id;
  private String username;
  private String password;
  private String email;
  private Role role;
  private String profilePictureUrl;

  public UserBuilder id(String id) {
    this.id = id;
    return this;
  }

  public UserBuilder username(String username) {
    this.username = username;
    return this;
  }

  public UserBuilder password(String password) {
    this.password = password;
    return this;
  }

  public UserBuilder email(String email) {
    this.email = email;
    return this;
  }

  public UserBuilder role(Role role) {
    this.role = role;
    return this;
  }

  public UserBuilder profilePictureUrl(String url) {
    this.profilePictureUrl = url;
    return this;
  }

  public User build() {
    if (username == null || username.isBlank()) {
      throw new IllegalStateException("username is required");
    }

    if (password == null || password.isBlank()) {
      throw new IllegalStateException("password is required");
    }

    // do not change builder properties, define new ones
    Role finalRole = role == null ? Role.USER : role;

    String finalPictureUrl = (profilePictureUrl == null || profilePictureUrl.isBlank()) ? "defaultPictureUrl"
        : profilePictureUrl;
    // it is not allowed to mutate builder in the build
    // either new User with all arguments. or no builder
    return new User(id, username, password, email, finalRole, finalPictureUrl);
  }
}
