package joao.faria.uolhostbackend.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> threatNoSuchElementException(NoSuchElementException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Essa lista não possui usuários disponíveis", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
}
