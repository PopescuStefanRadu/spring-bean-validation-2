package ro.popescustefanradu.validationdoizero.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class OilResourceModel {

    @NotNull
    BigDecimal totalNaturalGasAmount;

    @NotNull
    BigDecimal totalPetrolAmount;

    @Null(groups = NotInProduction.class)
    @NotNull(groups = {InProduction.class})
    LocalDate inProductionSince;

    @Null(groups = NotInProduction.class)
    @NotNull(groups = {InProduction.class})
    LocalDate inProductionUntil;

    @NotNull
    Boolean inProduction;

    @Null(groups = NotInProduction.class)
    @NotEmpty(groups = {InProduction.class})
    List<@NotEmpty(groups = {InProduction.class}) String> legalConditions;
}
