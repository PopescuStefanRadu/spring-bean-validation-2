package ro.popescustefanradu.validationdoizero.model.interfaces;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public interface InterfaceValidation {

    @NotNull
    @Min(10L)
    BigDecimal getNumber();
}
