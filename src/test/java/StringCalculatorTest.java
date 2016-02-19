import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new StringCalculator();
    }

    @Test
    public void emptyString_returnZero() throws Exception {
        String empty = "";
        int result = calculator.add(empty);
        assertEquals(0, result);
    }

    @Test
    public void nullString_returnZero() throws Exception {
        int result = calculator.add(null);
        assertEquals(0, result);
    }

    @Test
    public void singleNumber_returnNumber() throws Exception {
        String singleNumber = "45";
        int result = calculator.add(singleNumber);
        assertEquals(45, result);
    }

    @Test
    public void multipleNumberSeparaterComa_returnNumber() throws Exception {
        String multipleNumbersComa = "324,4554,12";
        int result = calculator.add(multipleNumbersComa);
        assertEquals(324 + 4554 + 12, result);
    }

    @Test (expected = OperationFormatException.class)
    public void wrongFormat_throwException() throws Exception {
        String wrongFormat = "34,ss,54";
        calculator.add(wrongFormat);
    }
}