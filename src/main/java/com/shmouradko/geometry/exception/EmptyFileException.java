package com.shmouradko.geometry.exception;

/**
 * Created by Сергей on 11.10.2016.
 */
public class EmptyFileException extends Exception {
    public EmptyFileException() {
    }

    public EmptyFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyFileException(String message) {
        super(message);
    }

    public EmptyFileException(Throwable cause) {
        super(cause);
    }
}