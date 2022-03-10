package com.academy.validation;

import com.academy.entity.CountryCode;
import com.academy.exception.ValidationException;

public class CountryCodeValidator extends Validator<String> {
    @Override
    void validate(String countryCode) {
        if (countryCode != null && !countryCode.isEmpty()) {
            try {
                CountryCode.valueOf(countryCode);
            } catch (IllegalArgumentException e) {
                throw new ValidationException("Country code can not be parsed from: " + countryCode);
            }
        }
    }
}
