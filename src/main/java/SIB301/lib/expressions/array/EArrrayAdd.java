package SIB301.lib.expressions.array;

import SIB301.lib.atoms.None;
import SIB301.lib.expressions.Expression;


public class EArrrayAdd extends Expression{

    private Expression value;
    EArray eArray;

    public EArrrayAdd(EArray eArray, Expression value) {
        this.eArray = eArray;
        this.value =value;
    }

    @Override
    public Expression interpreter() {
        eArray.add(value.interpreter());
        return new None();
    }
}
