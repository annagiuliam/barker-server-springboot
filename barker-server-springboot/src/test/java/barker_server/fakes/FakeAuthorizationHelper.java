package barker_server.fakes;

import barker_server.infrastructure.security.AuthorizationHelper;

public class FakeAuthorizationHelper extends AuthorizationHelper {
  private final String userId;
  private final String username;

  public FakeAuthorizationHelper(String userId, String username) {
    this.userId = userId;
    this.username = username;
  }

  @Override
  public String getCurrentUserId() {
    return userId;
  }

  @Override
  public String getCurrentUsername() {
    return username;
  }
}
