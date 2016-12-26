package SIB301.lib;

import SIB301.lib.atoms.EBool;
import SIB301.lib.expressions.Expression;
import SIB301.lib.expressions.bool_expression.BooleanExpression;


public class EWhile extends Expression {
    BooleanExpression condition;
    EBlock eBlock;

    public EWhile(BooleanExpression condition, EBlock eBlock) {
        this.condition = condition;
        this.eBlock = eBlock;
    }

    public BooleanExpression getCondition() {
        return condition;
    }

    public void setCondition(BooleanExpression condition) {
        this.condition = condition;
    }

    public EBlock geteBlock() {
        return eBlock;
    }

    public void seteBlock(EBlock eBlock) {
        this.eBlock = eBlock;
    }

    @Override
    public Expression interpreter() {
        while (((EBool) condition.interpreter()).getValue()) {
            eBlock.interpreter();
        }

        return super.interpreter();
    }
}
