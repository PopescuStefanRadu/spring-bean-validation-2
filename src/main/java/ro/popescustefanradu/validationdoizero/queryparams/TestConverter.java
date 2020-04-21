package ro.popescustefanradu.validationdoizero.queryparams;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ro.popescustefanradu.validationdoizero.queryparams.lib.SimpleFilter;

@Component
public class TestConverter implements Converter<String, SimpleFilter> {
    @Override
    public SimpleFilter convert(String source) {
        return null;
    }
}
