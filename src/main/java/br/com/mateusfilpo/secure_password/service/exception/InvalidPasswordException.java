package br.com.mateusfilpo.secure_password.service.exception;

import br.com.mateusfilpo.secure_password.model.BadPasswordResponse;

public class InvalidPasswordException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private BadPasswordResponse badPasswordResponse;

    public InvalidPasswordException(String msg, BadPasswordResponse badPasswordResponse) {
        super(msg);
        this.badPasswordResponse = badPasswordResponse;
    }

    public BadPasswordResponse getBadPasswordResponse() {
        return badPasswordResponse;
    }
}
