package ro.popescustefanradu.validationdoizero.queryparams.lib;

import lombok.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ComparableSimpleCondition<T extends Comparable<T>> extends SimpleCondition<T> {
    @NonNull
    ComparableFilterType filterType;

    @Override
    public <ENTITY> Specification<ENTITY> toSpec(GetExpression<T> expression) {
        return (root, query, criteriaBuilder) ->
                filterType.toPredicate(expression.getExpression(root, query), criteriaBuilder, value);
    }

    public enum ComparableFilterType {
        LESS_THAN {
            @Override
            public <T extends Comparable<T>> Predicate toPredicate(Expression<T> expression, CriteriaBuilder criteriaBuilder, T value) {
                return criteriaBuilder.lessThan(expression, value);
            }
        },
        LESS_THAN_OR_EQUAL {
            @Override
            public <T extends Comparable<T>> Predicate toPredicate(Expression<T> expression, CriteriaBuilder criteriaBuilder, T value) {
                return criteriaBuilder.lessThanOrEqualTo(expression, value);
            }
        },
        GREATER_THAN {
            @Override
            public <T extends Comparable<T>> Predicate toPredicate(Expression<T> expression, CriteriaBuilder criteriaBuilder, T value) {
                return criteriaBuilder.greaterThan(expression, value);
            }
        },
        GREATER_THAN_OR_EQUAL {
            @Override
            public <T extends Comparable<T>> Predicate toPredicate(Expression<T> expression, CriteriaBuilder criteriaBuilder, T value) {
                return criteriaBuilder.greaterThanOrEqualTo(expression, value);
            }
        };

        public abstract <T extends Comparable<T>> Predicate toPredicate(Expression<T> expression, CriteriaBuilder criteriaBuilder, T value);
    }
}
