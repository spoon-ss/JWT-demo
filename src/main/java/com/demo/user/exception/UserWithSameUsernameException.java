package com.demo.user.exception;

public class UserWithSameUsernameException extends RuntimeException {
    public UserWithSameUsernameException() {
    }

    public UserWithSameUsernameException(String message) {
        super(message);
    }

    public UserWithSameUsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserWithSameUsernameException(Throwable cause) {
        super(cause);
    }
}
