package ro.popescustefanradu.validationdoizero.queryparams.lib;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * FilterField that AND's all conditions
 */
public class FilterField<T> {
    List<Condition<T>> conditions;

    public <ENTITY> Specification<ENTITY> toSpec(GetExpression<T> getExpression) {
        return conditions.stream()
                .map(tCondition -> tCondition.<ENTITY>toSpec(getExpression))
                .reduce(Specification.where(null), Specification::and);
    }
}
