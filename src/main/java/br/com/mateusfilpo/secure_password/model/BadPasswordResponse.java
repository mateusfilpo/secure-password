package br.com.mateusfilpo.secure_password.model;

import java.util.List;

public record BadPasswordResponse(List<String> errors) {
}
