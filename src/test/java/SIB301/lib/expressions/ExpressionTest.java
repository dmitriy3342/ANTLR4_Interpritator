package SIB301.lib.expressions;

import SIB301.lib.atoms.EInt;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dmitr on 25.12.2016.
 */
public class ExpressionTest {
    @Test
    public void interpreter() throws Exception {
        EInt a = new EInt(10);
        EInt b = new EInt(20);
        EInt c = new EInt(21);
        EInt d = new EInt(1);

        EInt e = (EInt)(new Plus(new Minus(a,new Mul(b,c)),d)).interpreter();
        Integer result = (10 - 21*20)+1;
        System.out.println(e.getValue());
        assertEquals(result,e.getValue());

    }

}