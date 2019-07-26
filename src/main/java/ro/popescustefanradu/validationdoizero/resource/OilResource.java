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
import ro.popescustefanradu.validationdoizero.model.OilResourceModel;
import ro.popescustefanradu.validationdoizero.validators.OilResourceValidator;

import javax.validation.Valid;

@RestController
@RequestMapping("/oil-resource")
@RequiredArgsConstructor
public class OilResource {

    private final OilResourceValidator validator;

    @PostMapping

    public ResponseEntity saveOilResource(@Valid @RequestBody final OilResourceModel oilResourceModel,
                                          final BindingResult errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity<>(errors.getAllErrors().toString(), HttpStatus.I_AM_A_TEAPOT);
        }
        ValidationUtils.invokeValidator(validator, oilResourceModel, errors);

        return ResponseEntity.ok(oilResourceModel);
    }
}
