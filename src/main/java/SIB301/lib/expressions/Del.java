package SIB301.lib.expressions;


import SIB301.lib.atoms.EInt;

public class Del  extends Expression{
    Expression expression1;
    Expression expression2;

    public Del(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public Expression interpreter() {
        if (expression1 instanceof EInt && expression2 instanceof EInt) {
            return new EInt(((EInt) expression1).getValue() / ((EInt) expression2).getValue());
        }
        return new EInt(((EInt) expression1.interpreter()).getValue() / ((EInt) expression2.interpreter()).getValue()).interpreter();
    }
}
