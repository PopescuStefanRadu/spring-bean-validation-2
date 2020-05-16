package ro.popescustefanradu.validationdoizero.queryparams.lib;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class SimpleCondition<T> implements Condition<T> {
    protected T value;
}
