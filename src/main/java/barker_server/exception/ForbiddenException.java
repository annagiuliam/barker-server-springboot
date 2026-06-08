package barker_server.exception;

public class ForbiddenException extends RuntimeException {
  public ForbiddenException() {
    super("Forbidden: user is not authorized");
  }
}
