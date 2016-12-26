package SIB301.lib.expressions;

import SIB301.lib.atoms.EString;
import SIB301.lib.atoms.None;

/**
 * Created by dmitr on 25.12.2016.
 */
public class LengthEString extends Expression {
    Expression expression;

    public LengthEString(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Expression interpreter() {
        if(expression instanceof EString)
            return ((EString) expression).length();
        return new LengthEString(expression.interpreter()).interpreter();
    }
}
