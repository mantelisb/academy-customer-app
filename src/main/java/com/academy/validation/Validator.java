package com.academy.validation;

public abstract class Validator<T> {
    abstract void validate(T attribute);
}
