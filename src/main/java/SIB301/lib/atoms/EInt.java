package SIB301.lib.atoms;

import SIB301.lib.expressions.Atom;
import SIB301.lib.expressions.Expression;

/**
 * Created by dmitr on 25.12.2016.
 */
public class EInt extends Expression implements Atom {
    private Integer value;

    public EInt(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public Expression interpreter() {
        return this;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public Expression clone() {
        return new EInt(value);
    }
}
