package ro.popescustefanradu.validationdoizero.model.valuetype;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class TypedValue implements Value {

    @NotNull
    BigDecimal value;
    Type type;
}
