package SIB301.lib.expressions.array;

import SIB301.lib.atoms.EInt;
import SIB301.lib.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitr on 26.12.2016.
 */
public class EArray extends Expression {
    List< Expression >  list;



    public EArray(List<Expression> list) {
        this.list = list;
    }
    public EArray() {
        this.list = new ArrayList<>();
    }

    public void set(EInt eInt, Expression expression){
        list.add(eInt.getValue(),expression);
    }

    public void add(Expression expression){
        list.add(expression);
    }

    public Expression get(EInt eInt){
       return list.get(eInt.getValue());
    }





    @Override
    public Expression interpreter() {
        return super.interpreter();
    }
}
