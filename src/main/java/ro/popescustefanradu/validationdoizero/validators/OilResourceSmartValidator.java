package ro.popescustefanradu.validationdoizero.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.validation.SmartValidator;

@Slf4j
class OilResourceSmartValidator implements SmartValidator {

    @Override
    public void validate(final Object target, final Errors errors, final Object... validationHints) {

    }

    @Override
    public void validateValue(final Class<?> targetType, final String fieldName, final Object value, final Errors errors, final Object... validationHints) {
        log.info(validationHints.getClass().getName());
    }

    @Override
    public boolean supports(final Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(final Object target, final Errors errors) {

    }
}
