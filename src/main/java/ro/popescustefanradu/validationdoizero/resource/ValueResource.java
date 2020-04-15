package ro.popescustefanradu.validationdoizero.resource;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.popescustefanradu.validationdoizero.model.valuetype.Value;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller
@RequestMapping("/value")
@RequiredArgsConstructor
public class ValueResource {

    @Inject
    @NonNull
    private final ObjectMapper objectMapper;


    @NonNull
    private final LocalValidatorFactoryBean validator;

    @PostMapping
    public ResponseEntity validateValue(@RequestBody @Valid Value model,
                                      BindingResult bindingResult) throws JsonProcessingException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    objectMapper.writeValueAsString(bindingResult.getAllErrors()));
        }
        ValidationUtils.invokeValidator(validator, model, bindingResult, model.getType().getValidationGroup());

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    objectMapper.writeValueAsString(bindingResult.getAllErrors()));
        }
        return ResponseEntity.ok(model);
    }
}
