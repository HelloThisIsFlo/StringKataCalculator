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
    public void multipleNumberSeparaterComa_returnSum() throws Exception {
        String multipleNumbersComa = "324,554,12";
        int result = calculator.add(multipleNumbersComa);
        assertEquals(324 + 554 + 12, result);
    }

    @Test (expected = OperationFormatException.class)
    public void wrongFormat_throwException() throws Exception {
        String wrongFormat = "34,ss,54";
        calculator.add(wrongFormat);
    }

    @Test
    public void multipleNumberNewLineSeparator_returnSum() throws Exception {
        String multipleNumbersNewLine = "34\n77\n95,3";
        int result = calculator.add(multipleNumbersNewLine);
        assertEquals(34 + 77 + 95 + 3, result);
    }

    @Test
    public void customDelimiter_returnSum() throws Exception {
        String withCustomDelimiter = "//d\n23,55d11";
        int result = calculator.add(withCustomDelimiter);
        assertEquals(23 + 55 + 11, result);
    }

    @Test (expected = NegativeNumberNotAllowed.class)
    public void negativeNumber_throwException() throws Exception {
        String withNegativeNumber = "45,-1,33";
        calculator.add(withNegativeNumber);
    }

    @Test
    public void numberBiggerThan1000_ignoreThem() throws Exception {
        String bigNumbers = "24,65,6647,999";
        int result = calculator.add(bigNumbers);
        assertEquals(24 + 65 + 999, result);
    }
}