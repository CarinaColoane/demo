package cl.example.demoBCI.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PatternException extends RuntimeException {
    public PatternException(String message) {
        super(message);
    }
}
