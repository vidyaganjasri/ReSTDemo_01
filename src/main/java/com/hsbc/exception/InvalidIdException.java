package com.hsbc.exception;

//for it to be an exception it must extends Exception;
//for it to become full ledgedimpl constructors
//only two steps extend and create conostructor everytihng inclue it
public class InvalidIdException extends Exception{
    public InvalidIdException() {
    }

    public InvalidIdException(String message) {
        super(message);
    }

    public InvalidIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidIdException(Throwable cause) {
        super(cause);
    }

    public InvalidIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
