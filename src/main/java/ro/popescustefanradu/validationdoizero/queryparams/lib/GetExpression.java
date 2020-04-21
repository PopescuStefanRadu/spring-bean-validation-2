package ro.popescustefanradu.validationdoizero.queryparams.lib;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

@FunctionalInterface
public interface GetExpression<T> {
    Expression<T> getExpression(Root<?> root, CriteriaQuery<?> query);
}
