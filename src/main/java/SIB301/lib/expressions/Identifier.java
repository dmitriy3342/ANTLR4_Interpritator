package SIB301.lib.expressions;

import SIB301.lib.atoms.None;
import SIB301.lib.context.EContext;

public class Identifier extends Expression {

    EContext<Expression> eContext;
    String identifier;

    public Identifier(EContext<Expression> eContext, String identifier) {
        this.eContext = eContext;
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }


    public void putExpression(Expression expression) {
        eContext.addChild(identifier, expression);
    }

    public Expression getExpression() {
        return eContext.findChild(identifier) != null ? eContext.findChild(identifier) : new None();
    }

    @Override
    public Expression interpreter() {
        return getExpression().interpreter();
    }
}
