package ro.popescustefanradu.validationdoizero.queryparams.lib;

import org.springframework.data.jpa.domain.Specification;

@FunctionalInterface
public interface Filter<T> {
    <ENTITY> Specification<ENTITY> toSpec(GetExpression<T> getExpression);

    default RawOperator getRawOperator() {
        return null;
    };
}
