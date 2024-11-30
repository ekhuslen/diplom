package com.example.gymnasticsScoringSystem;

public class CoreException extends RuntimeException {
    private final String errorCode;

    public CoreException(String message) {
        super(message);
        this.errorCode = "UNKNOWN"; // Default error code
    }

    public CoreException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CoreException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
