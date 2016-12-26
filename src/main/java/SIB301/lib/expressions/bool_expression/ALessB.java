package SIB301.lib.expressions.bool_expression;

import SIB301.lib.atoms.EBool;
import SIB301.lib.atoms.EInt;
import SIB301.lib.expressions.Expression;

/**
 * Created by dmitr on 25.12.2016.
 */
public class ALessB extends BooleanExpression{
    Expression expression1;
    Expression expression2;

    public ALessB(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public Expression interpreter() {
        if (expression1 instanceof EInt && expression2 instanceof EInt) {
            return new EBool(((EInt) expression1).getValue() < ((EInt) expression2).getValue());
        }
        return new ALessB(expression1.interpreter(),expression2.interpreter()).interpreter();
    }
}
