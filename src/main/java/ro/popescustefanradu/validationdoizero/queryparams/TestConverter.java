package ro.popescustefanradu.validationdoizero.queryparams;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ro.popescustefanradu.validationdoizero.queryparams.lib.SimpleCondition;

@Component
public class TestConverter implements Converter<String, SimpleCondition> {
    @Override
    public SimpleCondition convert(String source) {
        return null;
    }
}
