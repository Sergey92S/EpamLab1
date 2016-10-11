package com.shmouradko.geometry.exception;

/**
 * Created by Сергей on 10.10.2016.
 */
public class WrongDataException extends Exception {
    public WrongDataException() {
    }

    public WrongDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongDataException(String message) {
        super(message);
    }

    public WrongDataException(Throwable cause) {
        super(cause);
    }
}
