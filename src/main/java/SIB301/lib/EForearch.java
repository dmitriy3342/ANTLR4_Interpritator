package SIB301.lib;


import SIB301.lib.atoms.EInt;
import SIB301.lib.atoms.EString;
import SIB301.lib.atoms.None;
import SIB301.lib.expressions.Expression;
import SIB301.lib.log.LogStats;

public class EForearch extends Expression {
    Expression expression1;
    Expression expression2;
    EBlock eBlock;

    public EForearch(Expression expression1, Expression expression2, EBlock eBlock) {
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.eBlock = eBlock;
    }

    public Expression getExpression1() {
        return expression1;
    }

    public void setExpression1(Expression expression1) {
        this.expression1 = expression1;
    }

    public Expression getExpression2() {
        return expression2;
    }

    public void setExpression2(Expression expression2) {
        this.expression2 = expression2;
    }

    public EBlock geteBlock() {
        return eBlock;
    }

    public void seteBlock(EBlock eBlock) {
        this.eBlock = eBlock;
    }

    @Override
    public Expression interpreter() {
        Expression expr1 = expression1.interpreter();
        Expression expr2 = expression2.interpreter();
        LogStats.println("(forearch.interpreter(" + expr1.toString() + "," + expr2.toString() + ")");

        if (expr1 instanceof EInt && expr2 instanceof EInt) {
            for (int i = ((EInt) expr1).getValue(); i <= ((EInt) expr2).getValue(); i++) {
                ((EInt) expr1).setValue(i);
                eBlock.interpreter();
            }
            return new None();
        }

        if (expr1 instanceof EString && expr2 instanceof EString) {
            Expression expr = expr1.interpreter();
            for (Character c : ((EString) expr2.interpreter()).getValue().toCharArray()) {
                ((EString) expr).setValue(c + "");
                eBlock.interpreter();
            }
            return new None();
        }

        return new None();
    }
}
