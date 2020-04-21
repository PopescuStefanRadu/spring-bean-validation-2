package ro.popescustefanradu.validationdoizero.config;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ro.popescustefanradu.validationdoizero.queryparams.TestConverter;
import ro.popescustefanradu.validationdoizero.queryparams.lib.QueryModelMethodProcessor;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    @NonNull
    private final TestConverter testConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(testConverter);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new QueryModelMethodProcessor());
    }
}
