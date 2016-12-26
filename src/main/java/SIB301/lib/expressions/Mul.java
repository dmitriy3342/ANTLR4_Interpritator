package SIB301.lib.expressions;


import SIB301.lib.atoms.EInt;

public class Mul extends Expression {
    Expression expression1;
    Expression expression2;

    public Mul(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public Expression interpreter() {
        if (expression1 instanceof EInt && expression2 instanceof EInt) {
            return new EInt(((EInt) expression1).getValue() * ((EInt) expression2).getValue());
        }
        return new Mul(expression1.interpreter(), expression2.interpreter()).interpreter();
    }
}
