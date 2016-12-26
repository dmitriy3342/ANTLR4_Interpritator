package SIB301.lib.expressions.array;


import SIB301.lib.atoms.EInt;
import SIB301.lib.atoms.None;
import SIB301.lib.expressions.Expression;



public class EArraySet extends Expression{

    private Expression index;
    private Expression value;
    EArray eArray;

    public EArraySet(EArray eArray, Expression index,Expression value) {
        this.eArray = eArray;
        this.index = index;
        this.value =value;
    }

    @Override
    public Expression interpreter() {
        eArray.set((EInt) index.interpreter(),value.interpreter());
        return new None();
    }
}
