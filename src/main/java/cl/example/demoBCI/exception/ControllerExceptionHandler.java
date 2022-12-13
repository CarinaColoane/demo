package cl.example.demoBCI.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserExistsException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ErrorMessage UserExistsException(UserExistsException ex) {
        ErrorMessage message = new ErrorMessage(
                ex.getMessage());

        return message;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> PatternException(ConstraintViolationException ex) {
        ErrorMessage message = new ErrorMessage(
                ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler({Throwable.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleRuntimeException(Throwable ex) {
        ErrorMessage message = new ErrorMessage(
                ex.getMessage());

        return message;
    }

}
