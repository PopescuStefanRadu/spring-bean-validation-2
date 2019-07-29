package ro.popescustefanradu.validationdoizero.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.popescustefanradu.validationdoizero.model.NotInProduction;
import ro.popescustefanradu.validationdoizero.model.OilResourceModel;
import ro.popescustefanradu.validationdoizero.validators.OilResourceValidator;

import javax.validation.groups.Default;

@RestController
@RequestMapping("/oil-resource")
@RequiredArgsConstructor
public class OilResource {

    private final OilResourceValidator validator;

    @PostMapping
    public ResponseEntity createOilResource(@RequestBody final OilResourceModel oilResourceModel,
                                            final BindingResult errors) {

        ValidationUtils.invokeValidator(validator, oilResourceModel, errors, Default.class, NotInProduction.class);
        if (errors.hasErrors()) {
            return new ResponseEntity<>(errors.getAllErrors().toString(), HttpStatus.I_AM_A_TEAPOT);
        }
        return ResponseEntity.ok(oilResourceModel);
    }
}
