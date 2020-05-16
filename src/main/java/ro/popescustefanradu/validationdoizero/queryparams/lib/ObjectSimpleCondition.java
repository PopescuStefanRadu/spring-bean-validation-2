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
public class ObjectSimpleCondition<T> extends SimpleCondition<T> {
    ObjectFilterType filterType;

    @Override
    public <ENTITY> Specification<ENTITY> toSpec(GetExpression<T> expression) {
        return (root, query, criteriaBuilder) ->
                filterType.toPredicate(expression.getExpression(root, query), criteriaBuilder, value);
    }

    public enum ObjectFilterType {
        EQUAL {
            @Override
            public <T> Predicate toPredicate(Expression<T> expression, CriteriaBuilder criteriaBuilder, T value) {
                return criteriaBuilder.equal(expression, value);
            }
        },
        NOT_EQUAL {
            @Override
            public <T> Predicate toPredicate(Expression<T> expression, CriteriaBuilder criteriaBuilder, T value) {
                return criteriaBuilder.notEqual(expression, value);
            }
        };

        public abstract <T> Predicate toPredicate(Expression<T> expression, CriteriaBuilder criteriaBuilder, T value);
    }
}
