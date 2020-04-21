package ro.popescustefanradu.validationdoizero.queryparams.lib;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.List;

public class SimpleCompositeFilter<T> extends CompositeFilter<T> {
    ListParamFilterType filterType;

    @Override
    public <ENTITY> Specification<ENTITY> toSpec(GetExpression<T> expression) {
        return (root, query, criteriaBuilder) ->
                filterType.toPredicate(expression.getExpression(root, query), criteriaBuilder, values);
    }

    public enum ListParamFilterType {
        IN {
            @Override
            public <T> Predicate toPredicate(Expression<T> expression, CriteriaBuilder criteriaBuilder, List<T> value) {
                return expression.in(value);
            }
        };

        public abstract <T> Predicate toPredicate(Expression<T> expression, CriteriaBuilder criteriaBuilder, List<T> value);
    }
}
