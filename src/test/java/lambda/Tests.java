package lambda;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests {

    @Test
    public void checkBMI() {
        double bmi = IBMI.bmi().getBMI(75, "Andrii", 80);

        Assert.assertEquals(bmi, 75.0);
    }

    @Test
    public void checkTrue() {
        ITrue iTrue = () -> System.out.println("true");

        iTrue.trueAboutYou();

        //i think the code work)))
    }

    @Test
    public void checkAssert() {
        boolean actual = IAssert.assertI().assertEquals("Andrii", "Andrii");

        Assert.assertTrue(actual);
    }
}
