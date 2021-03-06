package SIB301.lib;

import SIB301.lib.expressions.Expression;

public class EObject extends Expression{
    String Context ;

    public EObject(String context) {
        Context = context;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }

    @Override
    public Expression interpreter() {
        return this;
    }
}
