import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kushalkanavi on 5/19/17.
 */
public class AdditionTest {

    @Test
    public void testAddition() throws Exception {
        Addition<Integer> adder = new Addition<Integer>(new Integer(1), new Integer(2));
        double d = adder.sum();
        Assert.assertEquals(3.0, d, 0.1);

        Addition<Double> dadder = new Addition<Double>(new Double(1), new Double(2));
        d = dadder.sum();
        Assert.assertEquals(3.0f, d, 0.1);
    }
}