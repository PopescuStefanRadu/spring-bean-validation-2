package ro.popescustefanradu.validationdoizero.queryparams.lib;

import java.util.List;

public abstract class CompositeCondition<T> implements Condition<T> {
    protected List<T> values;
}
