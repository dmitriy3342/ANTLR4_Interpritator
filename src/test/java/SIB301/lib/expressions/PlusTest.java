package SIB301.lib.expressions;

import SIB301.lib.atoms.EInt;
import SIB301.lib.atoms.EString;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dmitr on 25.12.2016.
 */
public class PlusTest {
    @Test
    public void test() throws Exception {
        EInt eInt1 = new EInt(10);
        EInt eInt2 = new EInt(10);
        EString eString1 = new EString("string1");

        EInt result1 = (EInt) new Plus(eInt1, eInt2).interpreter();
        assertEquals(new Integer(20), result1.getValue());
        System.out.println(result1.getValue());

        EString result2 = (EString) new Plus(eString1, eInt2).interpreter();
        assertEquals("string110", result2.getValue());
        System.out.println(result2.getValue());


    }

}