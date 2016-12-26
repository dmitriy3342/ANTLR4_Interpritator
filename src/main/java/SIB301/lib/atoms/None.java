package SIB301.lib.atoms;

import SIB301.lib.expressions.Expression;


public class None extends Expression {
    @Override
    public Expression interpreter() {
        return new None();
    }


    @Override
    public String toString() {
        return "None";
    }
}
