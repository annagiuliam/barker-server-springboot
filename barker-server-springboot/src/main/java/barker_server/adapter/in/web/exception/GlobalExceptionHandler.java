package barker_server.adapter.in.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import barker_server.adapter.in.web.dto.ErrorResponse;
import barker_server.exception.ForbiddenException;
import barker_server.exception.InvalidCredentialsException;
import barker_server.exception.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleUserNotFound(
      UserNotFoundException exception,
      HttpServletRequest request) {

    ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
        HttpStatus.NOT_FOUND.getReasonPhrase(),
        exception.getMessage(),
        request.getRequestURI());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler(InvalidCredentialsException.class)
  public ResponseEntity<ErrorResponse> handleInvalidCredentials(
      InvalidCredentialsException exception,
      HttpServletRequest request) {
    ErrorResponse error = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(),
        HttpStatus.UNAUTHORIZED.getReasonPhrase(),
        exception.getMessage(),
        request.getRequestURI());

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidationError(
      MethodArgumentNotValidException exception,
      HttpServletRequest request) {
    String message = exception.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(FieldError::getDefaultMessage)
        .reduce((a, b) -> a + "; " + b)
        .orElse("Validation failed");

    ErrorResponse error = new ErrorResponse(
        HttpStatus.BAD_REQUEST.value(),
        HttpStatus.BAD_REQUEST.getReasonPhrase(),
        message,
        request.getRequestURI());

    return ResponseEntity.badRequest().body(error);
  }

  @ExceptionHandler(ForbiddenException.class)
  public ResponseEntity<ErrorResponse> handleForbiddenException(
      ForbiddenException exception,
      HttpServletRequest request) {

    ErrorResponse error = new ErrorResponse(HttpStatus.FORBIDDEN.value(),
        HttpStatus.FORBIDDEN.getReasonPhrase(),
        exception.getMessage(),
        request.getRequestURI());

    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
  }

}
