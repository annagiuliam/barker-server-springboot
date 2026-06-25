package barker_server.exception;

public class InvalidCredentialsException extends RuntimeException {
  public InvalidCredentialsException() {
    super("Invalid credentials");
  }
}
