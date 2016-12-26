package SIB301.lib.atoms;

import SIB301.lib.expressions.Atom;
import SIB301.lib.expressions.Expression;

/**
 * Created by dmitr on 25.12.2016.
 */
public class EBool extends Expression implements Atom {
    Boolean value;

    public EBool(Boolean value) {
        this.value = value;
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
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
}
