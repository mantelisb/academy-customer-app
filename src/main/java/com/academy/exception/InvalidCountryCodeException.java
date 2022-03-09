package com.academy.exception;

public class InvalidCountryCodeException extends MandatoryValueMissingException {
    public InvalidCountryCodeException(String message) {
        super("Country code can not be parsed from: " + message);
    }
}
