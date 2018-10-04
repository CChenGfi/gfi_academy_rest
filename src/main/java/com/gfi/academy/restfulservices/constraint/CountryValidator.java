package com.gfi.academy.restfulservices.constraint;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Slf4j
public class CountryValidator implements ConstraintValidator<Country, String> {

    private static final List<String> LIST_COUNTRY = Arrays.asList(Locale.getISOCountries());

    @Override
    public boolean isValid(String country, ConstraintValidatorContext constraintValidatorContext) {
        log.info("Validating EmployeeDTO country field...");
        if (country == null) {
            return false;
        }
        return LIST_COUNTRY.contains(country);
    }
}
