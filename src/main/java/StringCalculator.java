import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String numbersString) throws NumberStringFormatException {
        if (numbersString == null || numbersString.isEmpty()) {
            return 0;
        } else {
            return addStringNotNull(numbersString);
        }
    }

    private int addStringNotNull(String numbersString) throws NumberStringFormatException{
        NumberString delimiterAndNumbers = separateNumbersAndDelimiter(numbersString);
        List<Integer> numbers = parseNumbers(delimiterAndNumbers);
        return makeSum(numbers);
    }

    private NumberString separateNumbersAndDelimiter(String numbersString) {
        if (hasDelimiter(numbersString)) {
            int endOfDelimiterIndex = 4;
            String delimiter = numbersString.substring(0, endOfDelimiterIndex);
            String numbers = numbersString.substring(endOfDelimiterIndex);
            return new NumberString(delimiter, numbers);
        } else {
            return new NumberString("", numbersString);
        }
    }

    private boolean hasDelimiter(String numbersString) {
        return numbersString.startsWith("//");
    }

    private List<Integer> parseNumbers(NumberString numberString) throws NumberStringFormatException {
        String[] fragments = numberString.numbers.split(makeSplitRegex(numberString.delimiter));
        List<Integer> numbers = new ArrayList<>(fragments.length);
        for (String fragment: fragments) {
            numbers.add(parseInt(fragment));
        }
        return numbers;
    }

    private String makeSplitRegex(String customDelimiter) {
        return "[," + customDelimiter + "\\n]";
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

    private static class NumberString {
        public final String delimiter;
        public final String numbers;

        public NumberString(String delimiter, String numbers) {
            this.delimiter = delimiter;
            this.numbers = numbers;
        }
    }


}
