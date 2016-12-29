package SIB301.lib.atoms;

import SIB301.lib.expressions.Atom;
import SIB301.lib.expressions.Expression;

/**
 * Created by dmitr on 26.12.2016.
 */
public class EChar extends Expression implements Atom {

    Character value ;

    public EChar(Character value) {
        this.value = value;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    @Override
    public Expression interpreter() {

        return super.interpreter();
    }

    @Override
    public String toString() {
        return value.toString();
    }


    @Override
    public Expression clone() {
        return new EChar(value);
    }
}
