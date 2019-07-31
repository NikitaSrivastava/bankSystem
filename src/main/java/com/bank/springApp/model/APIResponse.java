package com.bank.springApp.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class APIResponse {
    private boolean success;
    private int status;
    private Object response;
    private Map<String, String> error = new HashMap<>();

    private APIResponse(boolean success, String message, int statusCode) {
        this.success = success;
        this.status = statusCode;
        this.error.put("message", message);
    }

    private APIResponse(boolean success, Object response, int statusCode) {
        this.success = success;
        this.status = statusCode;
        if (Objects.isNull(response))
            this.response = new HashMap<>();
        else
          this.response = response;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, String> getError() {
        return error;
    }

    public void setError(Map<String, String> error) {
        this.error = error;
    }

    public static ResponseEntity renderError(boolean success, String message, HttpStatus status) {
        return new ResponseEntity<>(new APIResponse(success, message, status.value()), status);
    }

    public static ResponseEntity renderSuccess(Object object) {
        return new ResponseEntity<>(new APIResponse(true,  object, 200), HttpStatus.OK);
    }

    public static ResponseEntity renderPojoResponse(Object object) {
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

}
