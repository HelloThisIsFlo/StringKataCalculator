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
    public void multipleNumbers_returnSum() throws Exception {
        String numbers = "1,2,65645,6";
        int result = calculator.add(numbers);

        assertEquals(1 + 2 + 65645 + 6, result);
    }

    @Test (expected = NumberStringFormatException.class)
    public void wrongFormattedString_throwException() throws Exception {
        String wrongFormat = "1,2345,aa,4";
        calculator.add(wrongFormat);
    }

    @Test
    public void testAcceptNewLineAsWellAsComma() throws Exception {
        String numbersWithMixedDelimiters = "1,234\n55,5";
        int result = calculator.add(numbersWithMixedDelimiters);

        assertEquals(1 + 234 + 55 + 5, result);
    }
}