package SIB301.lib.expressions;

import SIB301.lib.atoms.EInt;
import SIB301.lib.atoms.EString;

public class Plus extends Expression {
    Expression expression1;
    Expression expression2;

    public Plus(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public Expression interpreter() {
        //Если expressions атомарны
        if ((expression1 instanceof EInt | expression1 instanceof EString) &&
                (expression2 instanceof EInt | expression2 instanceof EString)) {
            //Если числовые
            if (expression1 instanceof EInt && expression2 instanceof EInt) {
                return new EInt(((EInt) expression1).getValue() + ((EInt) expression2).getValue());
            }
            return new EString(expression1.toString() + expression2.toString());
        }
        return new Plus(expression1.interpreter(),expression2.interpreter()).interpreter();
    }
}
