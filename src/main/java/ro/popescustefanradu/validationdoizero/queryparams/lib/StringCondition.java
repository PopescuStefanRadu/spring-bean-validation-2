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
public class StringCondition extends SimpleCondition<String> {
    StringFilterType filterType;

    @Override
    public <ENTITY> Specification<ENTITY> toSpec(GetExpression<String> expression) {
        return (root, query, criteriaBuilder) ->
                filterType.toPredicate(expression.getExpression(root, query), criteriaBuilder, value);
    }

    public enum StringFilterType {
        LIKE_IGNORE_CASE {
            @Override
            public Predicate toPredicate(Expression<String> expression, CriteriaBuilder criteriaBuilder, String value) {
                return criteriaBuilder.like(criteriaBuilder.lower(expression), "%" + value.toLowerCase() + "%");
            }
        },
        NOT_LIKE_IGNORE_CASE {
            @Override
            public Predicate toPredicate(Expression<String> expression, CriteriaBuilder criteriaBuilder, String value) {
                return criteriaBuilder.notLike(criteriaBuilder.lower(expression), "%" + value.toLowerCase() + "%");
            }
        },
        LIKE {
            @Override
            public Predicate toPredicate(Expression<String> expression, CriteriaBuilder criteriaBuilder, String value) {
                return criteriaBuilder.like(expression, "%" + value + "%");
            }
        },
        NOT_LIKE {
            @Override
            public Predicate toPredicate(Expression<String> expression, CriteriaBuilder criteriaBuilder, String value) {
                return criteriaBuilder.notLike(expression, "%" + value + "%");
            }
        };
        public abstract Predicate toPredicate(Expression<String> expression, CriteriaBuilder criteriaBuilder, String value);
    }
}
