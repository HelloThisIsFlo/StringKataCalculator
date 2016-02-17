import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class NumberString {

    private final String numbersWithOptionalDelimiter;

    private String delimiter;
    private String numbers;

    public NumberString(String numbersWithOptionalDelimiter) {
        checkNotNull(numbersWithOptionalDelimiter);
        this.numbersWithOptionalDelimiter = numbersWithOptionalDelimiter;
        separateNumbersAndDelimiter();
    }

    private void separateNumbersAndDelimiter() {
        if (hasDelimiter()) {
            int endOfDelimiterIndex = 4;
            delimiter = numbersWithOptionalDelimiter.substring(0, endOfDelimiterIndex);
            numbers = numbersWithOptionalDelimiter.substring(endOfDelimiterIndex);
        } else {
            delimiter = "";
            numbers = numbersWithOptionalDelimiter;
        }
    }

    private boolean hasDelimiter() {
        return numbersWithOptionalDelimiter.startsWith("//");
    }

    public List<Integer> getParsedNumbers() throws NumberStringFormatException {
        String[] fragments = numbers.split(makeSplitRegex());
        List<Integer> numbers = new ArrayList<>(fragments.length);
        for (String fragment: fragments) {
            numbers.add(parseInt(fragment));
        }
        return numbers;
    }

    private String makeSplitRegex() {
        return "[," + delimiter + "\\n]";
    }

    private int parseInt(String toParse) throws NumberStringFormatException {
        try {
            return Integer.parseInt(toParse);
        } catch (NumberFormatException e) {
            throw new NumberStringFormatException(e);
        }
    }
}
