package br.com.mateusfilpo.secure_password.controller.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InvalidPasswordError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long timestamp;
    private Integer status;
    private String error;
    private List<String> messages = new ArrayList<>();
    private String path;

    public InvalidPasswordError() {
    }

    public InvalidPasswordError(Long timestamp, Integer status, String error, String path) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<String> getMessages() {
        return messages;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
