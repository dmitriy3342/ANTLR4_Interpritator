package SIB301.lib.expressions.array;

import SIB301.lib.atoms.EInt;
import SIB301.lib.atoms.None;
import SIB301.lib.expressions.Expression;

/**
 * Created by dmitr on 26.12.2016.
 */
public class EArrayGet extends Expression {

    private Expression index;
    EArray eArray;

    public EArrayGet(EArray eArray, Expression index) {
        this.eArray = eArray;
        this.index = index;
    }

    @Override
    public Expression interpreter() {
        if(eArray == null)
            return  new None();
        return eArray.get((EInt) index.interpreter()).interpreter();
    }
}
