package ro.popescustefanradu.validationdoizero.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.popescustefanradu.validationdoizero.model.InterfaceValidation1Model;
import ro.popescustefanradu.validationdoizero.model.InterfaceValidation2Model;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller
@RequestMapping("/interface")
@RequiredArgsConstructor
public class InterfaceResource {

    @Inject
    @NonNull
    private final ObjectMapper objectMapper;

    @PostMapping("/interf1")
    public ResponseEntity postInterf1(@RequestBody @Valid InterfaceValidation1Model model,
                                       BindingResult bindingResult) throws JsonProcessingException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    objectMapper.writeValueAsString(bindingResult.getAllErrors()));
        }
        return ResponseEntity.ok(model);
    }

    @PostMapping("/interf2")
    public ResponseEntity postInterf1(@RequestBody @Valid InterfaceValidation2Model model,
                                      BindingResult bindingResult) throws JsonProcessingException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    objectMapper.writeValueAsString(bindingResult.getAllErrors()));
        }
        return ResponseEntity.ok(model);
    }

}
