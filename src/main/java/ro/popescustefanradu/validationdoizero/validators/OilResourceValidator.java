package ro.popescustefanradu.validationdoizero.validators;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.SmartValidator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import ro.popescustefanradu.validationdoizero.model.OilResourceModel;

@Component
@RequiredArgsConstructor
public class OilResourceValidator implements SmartValidator {
    private final LocalValidatorFactoryBean validator;

    @Override
    public void validate(final Object target, final Errors errors, final Object... validationHints) {
        if (validationHints == null || validationHints.length == 0) {
            validate(target, errors);
            return;
        }
        validator.validate(target, errors, validationHints);
        // continue with custom class level validation.
        // validate according to some conditional validation hint (marker interface like NotInProduction.class)
        // keep validating with custom class level validation
    }

    @Override
    public boolean supports(final Class<?> clazz) {
        return OilResourceModel.class.equals(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        validator.validate(target, errors);
    }
}
