package barker_server.infrastructure.persistence;

import barker_server.domain.model.Role;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserDocument {
  @Id
  private String id;

  @Indexed(unique = true)
  private String username;

  private String password;
  private Role role;
  private String email;
  private String profilePictureUrl;

  public UserDocument(
      String id,
      String username,
      String password,
      Role role,
      String email,
      String profilePictureUrl) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.role = role;
    this.email = email;
    this.profilePictureUrl = profilePictureUrl;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getProfilePictureUrl() {
    return profilePictureUrl;
  }

  public void setProfilePictureUrl(String url) {
    this.profilePictureUrl = url;
  }
}
