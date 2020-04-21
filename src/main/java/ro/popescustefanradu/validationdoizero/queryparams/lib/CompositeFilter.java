package ro.popescustefanradu.validationdoizero.queryparams.lib;

import java.util.List;

public abstract class CompositeFilter<T> implements Filter<T> {
    protected List<T> values;
}
