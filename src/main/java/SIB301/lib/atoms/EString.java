package SIB301.lib.atoms;

import SIB301.lib.expressions.Atom;
import SIB301.lib.expressions.Expression;


public class EString extends Expression implements Atom {
    private String value;

    public EString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public EString substring(Integer start, Integer finish){
        return new EString(value.substring(start,finish));
    }

    public EInt length(){
        return new EInt(value.length());
    }

    @Override
    public Expression interpreter() {
        return this;
    }

    @Override
    public String toString() {
        return value;
    }
}
