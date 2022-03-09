package com.academy.exception;

public class CustomerNotAdultException extends MandatoryValueMissingException {
    public CustomerNotAdultException() {
        super("Customer not adult");
    }
}
