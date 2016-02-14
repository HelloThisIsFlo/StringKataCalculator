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
        String singleNumber = "3";
        int result = calculator.add(singleNumber);

        assertEquals(3, result);
    }

    @Test
    public void multipleNumbersSeparatedComa_returnsSum() throws Exception {
        String numbers = "23,44,5,1";
        int result = calculator.add(numbers);

        assertEquals(23 + 44 + 5 + 1, result);
    }
}