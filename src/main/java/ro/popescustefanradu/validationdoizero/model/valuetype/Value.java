package ro.popescustefanradu.validationdoizero.model.valuetype;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public interface Value {


    @Min(0)
    @Max(value = 100, groups = Percentage.class)
    BigDecimal getValue();

    @NotNull
    TypedValue.Type getType();


    @RequiredArgsConstructor
    enum Type {
        FIXED(null), PERCENTAGE(Percentage.class);

        @Getter
        public final Class validationGroup;
    }

    interface Percentage {}
}
