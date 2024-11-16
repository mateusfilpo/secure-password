package br.com.mateusfilpo.secure_password.controller.exception;

import br.com.mateusfilpo.secure_password.service.exception.InvalidPasswordException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<InvalidPasswordError> handleInvalidPasswordException(InvalidPasswordException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        InvalidPasswordError err = new InvalidPasswordError(System.currentTimeMillis(), status.value(), "Senha inválida", request.getRequestURI());
        err.getMessages().addAll(e.getBadPasswordResponse().errors());
        return ResponseEntity.status(status).body(err);
    }
}
