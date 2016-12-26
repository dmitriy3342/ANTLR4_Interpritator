package SIB301.lib.expressions;

import SIB301.lib.atoms.None;

/**
 * Created by dmitr on 25.12.2016.
 */
public class Assignment extends  Expression {
    Identifier identifier;
    Expression expression;

    public Assignment(Identifier identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public Expression interpreter() {
        identifier.putExpression(expression);
        return new None();
    }
}
