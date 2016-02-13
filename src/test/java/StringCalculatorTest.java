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
    public void emptyString_returnsZero() throws Exception {
        String empty = "";
        int result = calculator.add(empty);

        assertEquals(0, result);
    }

    @Test
    public void nullString_returnsZero() throws Exception {
        int result = calculator.add(null);

        assertEquals(0, result);
    }

    @Test
    public void singleNumber_returnsNumber() throws Exception {
        String singleNumber = "1";
        int result = calculator.add(singleNumber);

        assertEquals(1, result);
    }

    @Test
    public void twoNumbers_returnSum() throws Exception {
        String numbers = "1,2";
        int result = calculator.add(numbers);

        assertEquals(1 + 2, result);
    }


}