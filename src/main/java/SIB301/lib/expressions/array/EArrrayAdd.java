package SIB301.lib.expressions.array;

import SIB301.lib.EBlock;
import SIB301.lib.atoms.EInt;
import SIB301.lib.atoms.None;
import SIB301.lib.expressions.Expression;
import SIB301.table_ids.TableIDsWithScope;

/**
 * Created by dmitr on 26.12.2016.
 */
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
