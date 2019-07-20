package ro.popescustefanradu.validationdoizero.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class OilResourceModel {

    @NotNull
    BigDecimal naturalGasAmount;

    @NotNull
    BigDecimal petrolAmount;

    @NotNull
    LocalDate inProductionSince;

    @NotNull
    LocalDate inProductionUntil;

    @NotNull
    Boolean inProduction;

    @NotEmpty
    List<@NotEmpty String> legalConditions;
}
