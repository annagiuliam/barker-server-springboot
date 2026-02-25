package barker_server.domain.model.user;

import barker_server.domain.model.Role;

public class UserBuilder {
  private String id;
  private String username;
  private String password;
  private Role role;
  private String profilePictureUrl;

  // getters
  public String getId() {
    return id;
  };

  public String getUsername() {
    return username;
  };

  public String getPassword() {
    return password;
  };

  public Role getRole() {
    return role;
  };

  public String getProfilePictureUrl() {
    return profilePictureUrl;
  };

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
    Role finalRole = role == null ? role : Role.USER;

    String finalPictureUrl = (profilePictureUrl == null || profilePictureUrl.isBlank()) ? "defaultPictureUrl"
        : profilePictureUrl;
    // it is not allowed to mutate builder in the build
    // either new User with all arguments. or no builder
    return new User(id, username, password, finalRole, finalPictureUrl);
  }
}
