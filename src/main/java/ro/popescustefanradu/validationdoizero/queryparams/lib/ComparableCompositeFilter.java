package ro.popescustefanradu.validationdoizero.queryparams.lib;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.List;

public class ComparableCompositeFilter<T extends Comparable<T>> extends CompositeFilter<T> {
    ComparableCompositeFilterType filterType;

    public <ENTITY> Specification<ENTITY> toSpec(GetExpression<T> expression) {
        return (root, query, criteriaBuilder) ->
                filterType.toPredicate(expression.getExpression(root, query), criteriaBuilder, values);
    }

    public enum ComparableCompositeFilterType {
        BETWEEN {
            @Override
            public <T extends Comparable<T>> Predicate toPredicate(Expression<? extends T> expression, CriteriaBuilder criteriaBuilder, List<T> value) {
                return criteriaBuilder.between(expression, value.get(0), value.get(1));
            }
        };

        public abstract <T extends Comparable<T>> Predicate toPredicate(Expression<? extends T> expression, CriteriaBuilder criteriaBuilder, List<T> value);
    }
}
