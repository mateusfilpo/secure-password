package br.com.mateusfilpo.secure_password.service;

import br.com.mateusfilpo.secure_password.model.BadPasswordResponse;
import br.com.mateusfilpo.secure_password.service.exception.InvalidPasswordException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PasswordService {

    public void validatePassword(String password) {
        BadPasswordResponse badPasswordResponse = new BadPasswordResponse(new ArrayList<>());

        performPasswordValidation(password, badPasswordResponse);

        if (!badPasswordResponse.errors().isEmpty()) {
            throw new InvalidPasswordException("Senha inválida", badPasswordResponse);
        }
    }

    private void performPasswordValidation(String password, BadPasswordResponse badPasswordResponse) {
        isEightCharactersLong(password, badPasswordResponse);
        containsUpperCase(password, badPasswordResponse);
        containsLowerCase(password, badPasswordResponse);
        containsDigit(password, badPasswordResponse);
        containsSpecial(password, badPasswordResponse);
    }

    private void isEightCharactersLong(String password, BadPasswordResponse badPasswordResponse) {
        if (password.trim().length() < 8) {
            badPasswordResponse.errors().add("A senha deve conter pelo menos 8 caracteres.");
        }
    }

    private void containsUpperCase(String password, BadPasswordResponse badPasswordResponse) {
        if (!password.matches(".*[A-Z].*")) {
            badPasswordResponse.errors().add("A senha deve conter pelo menos uma letra maiúscula.");
        }
    }

    private void containsLowerCase(String password, BadPasswordResponse badPasswordResponse) {
        if (!password.matches(".*[a-z].*")) {
            badPasswordResponse.errors().add("A senha deve conter pelo menos uma letra minúscula");
        }
    }

    private void containsDigit(String password, BadPasswordResponse badPasswordResponse) {
        if (!password.matches(".*[0-9].*")) {
            badPasswordResponse.errors().add("A senha deve conter pelo menos um dígito numérico.");
        }
    }

    private void containsSpecial(String password, BadPasswordResponse badPasswordResponse) {
        if (!password.trim().matches(".*[^a-zA-Z0-9].*")) {
            badPasswordResponse.errors().add("A senha deve conter pelo menos um caractere especial (ex: !, @, #, $, etc.).");
        }
    }
}
