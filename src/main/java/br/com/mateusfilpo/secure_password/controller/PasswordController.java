package br.com.mateusfilpo.secure_password.controller;

import br.com.mateusfilpo.secure_password.model.Password;
import br.com.mateusfilpo.secure_password.service.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validate-password")
public class PasswordController {

    public final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping
    public ResponseEntity<Void> validatePassword(@RequestBody Password password) {

        passwordService.validatePassword(password.password());

        return ResponseEntity.noContent().build();
    }
}
