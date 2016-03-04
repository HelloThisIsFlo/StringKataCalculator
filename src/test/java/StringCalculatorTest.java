import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new StringCalculator();
    }

    @Test
    public void emptyString_returnZero() throws Exception {
        String emptyString = "";
        int result = calculator.add(emptyString);

        assertEquals(0, result);
    }

    @Test
    public void nullString_returnZero() throws Exception {
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
    public void multipleNumbersSeparatedByComma_returnSum() throws Exception {
        String withComma = "1,45,33";
        int result = calculator.add(withComma);
        assertEquals(1 + 45 + 33, result);
    }

    @Test(expected = WrongOperationFormat.class)
    public void wrongFormat_throwException() throws Exception {
        String wrongFormat = "23,55,sd,1";
        calculator.add(wrongFormat);
    }

    @Test
    public void newLineAsDelimiter_returnSum() throws Exception {
        String withNewLine = "23,55\n12\n1";
        int result = calculator.add(withNewLine);
        assertEquals(23 + 55 + 12 + 1, result);
    }

    @Test
    public void useACustomDelimiter_returnsSum() throws Exception {
        String withCustomDelimiter = "//d\n1,4,5d54\n33d12";

        int result = calculator.add(withCustomDelimiter);
        assertEquals(1 + 4 + 5 + 54 + 33 + 12, result);
    }
}