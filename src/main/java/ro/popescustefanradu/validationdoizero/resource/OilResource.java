package ro.popescustefanradu.validationdoizero.resource;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OilResource {

    @NotNull
    BigDecimal gasAmount;

    @NotNull
    BigDecimal petrolAmount;

    @NotNull
    LocalDateTime inProductionSince;

    @NotNull
    LocalDateTime inProductionUntil;

    @NotNull
    boolean inProduction;
}
