package SIB301.lib;

import SIB301.lib.atoms.EBool;
import SIB301.lib.expressions.Expression;
import SIB301.lib.expressions.bool_expression.BooleanExpression;

public class EIfElse extends Expression {
    BooleanExpression condition;
    EBlock ifblock;
    EBlock elseblock;

    public EIfElse(BooleanExpression condition, EBlock ifblock, EBlock elseblock) {
        this.condition = condition;
        this.ifblock = ifblock;
        this.elseblock = elseblock;
    }

    public EIfElse(BooleanExpression condition, EBlock ifblock) {
        this(condition,ifblock,null);
    }


    @Override
    public Expression interpreter() {
        if(((EBool)condition.interpreter()).getValue() )
            ifblock.interpreter();
        else{
            if(elseblock!=null)
                elseblock.interpreter();
        }
        return super.interpreter();
    }

    /**
     * Created by dmitr on 26.12.2016.
     */
    public static class EWhile {
    }
}
