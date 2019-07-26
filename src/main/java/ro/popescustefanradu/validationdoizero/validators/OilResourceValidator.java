package ro.popescustefanradu.validationdoizero.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ro.popescustefanradu.validationdoizero.model.OilResourceModel;

public class OilResourceValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return OilResourceModel.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        if (!(target instanceof OilResourceModel)) {
            return;
        }
        final OilResourceModel oilResource = (OilResourceModel) target;

    }
}
