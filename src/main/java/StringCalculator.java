import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String numbersString) throws NumberStringFormatException {
        if (numbersString == null || numbersString.isEmpty()) {
            return 0;
        } else {
            List<Integer> numbers = parseNumbers(numbersString);
            return makeSum(numbers);
        }
    }

    private List<Integer> parseNumbers(String numbersString) throws NumberStringFormatException {
        String[] fragments = numbersString.split(makeSplitRegex());
        List<Integer> numbers = new ArrayList<>(fragments.length);
        for (String fragment: fragments) {
            numbers.add(parseInt(fragment));
        }
        return numbers;
    }

    private String makeSplitRegex() {
        return "[,\\n]";
    }

    private int parseInt(String toParse) throws NumberStringFormatException {
        try {
            return Integer.parseInt(toParse);
        } catch (NumberFormatException e) {
            throw new NumberStringFormatException(e);
        }
    }

    private int makeSum(List<Integer> numbers) {
        int result = 0;
        for (Integer i: numbers) {
            result += i;
        }
        return result;
    }


}
