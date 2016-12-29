package SIB301.lib.expressions;

import SIB301.lib.atoms.*;
import SIB301.lib.expressions.array.EArray;

public class Assignment extends Expression {
    Identifier identifier;
    Expression expression;

    public Assignment(Identifier identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public Expression interpreter() {
        Expression tmp;
        if (expression instanceof EInt) {
            tmp = expression.clone();
        } else if (expression instanceof EString) {
            tmp = expression.clone();
        } else if (expression instanceof EBool) {
            tmp = expression.clone();
        } else if (expression instanceof EChar) {
            tmp = expression.clone();
        } else if (expression instanceof EArray) {
            tmp = expression.clone();
        } else {
            tmp = expression;
        }

        identifier.putExpression(tmp);
        return new None();
    }
}
