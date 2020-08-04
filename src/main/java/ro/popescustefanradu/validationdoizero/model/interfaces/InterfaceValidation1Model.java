package ro.popescustefanradu.validationdoizero.model.interfaces;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InterfaceValidation1Model implements InterfaceValidation {
    private BigDecimal number;
}
