package barker_server.infrastructure.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationHelper {

  public String getCurrentUsername() {
    var auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth == null || !auth.isAuthenticated()) {
      return null;
    }
    Object principal = auth.getPrincipal();
    if (principal instanceof UserPrincipal) {
      return ((UserPrincipal) principal).getUsername();
    }
    return null;
  }

  public String getCurrentUserId() {
    var auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth == null || !auth.isAuthenticated()) {
      return null;
    }
    Object principal = auth.getPrincipal();
    if (principal instanceof UserPrincipal) {
      return ((UserPrincipal) principal).getUserId();
    }
    return null;
  }
}
