public class StringCalculator {

    /**
     * Return the sum of numbers contained in a String.
     *
     * Format :
     *  * The numbers should be separated by a comma
     *      ("1,432,4")
     *  * A custom delimiter can be defined at the start of the String. It is surrounded by "//" and "\n"
     *      ("//d\n23d44d653")
     */
    public int add(String numbers) throws NumberStringFormatException{
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        } else {
            if (hasDelimiter(numbers)) {
                NumbersStringWithDelimiter withDelimiter = extractDelimiter(numbers);
                return getSumFromString(withDelimiter.numbersString, withDelimiter.customDelimiter);
            } else {
                return getSumFromString(numbers);
            }
        }
    }

    private boolean hasDelimiter(String numberString) {
        return numberString.matches(makeCustomDelimiterRegex());
    }

    private String makeCustomDelimiterRegex() {
        // String.matches(regex) matches the WHOLE String : So using ".*" at the end.
        return "^(//.\\n).*";
    }

    private NumbersStringWithDelimiter extractDelimiter(String numbersWithDelimiter) {
        int endDelimiterIndex = 4;
        String delimiter = numbersWithDelimiter.substring(0, endDelimiterIndex);
        String numbersWithoutDelimiter = numbersWithDelimiter.substring(endDelimiterIndex);

        return new NumbersStringWithDelimiter(numbersWithoutDelimiter, delimiter);
    }

    private int getSumFromString(String numbersString) throws NumberStringFormatException {
        String[] fragments = numbersString.split(makeSplitRegex());
        int result = 0;
        for (String fragment: fragments) {
            result += parseInt(fragment);
        }
        return result;
    }

    private int parseInt(String toParse) throws NumberStringFormatException {
        try {
            return Integer.parseInt(toParse);
        } catch (NumberFormatException e) {
            throw new NumberStringFormatException(e);
        }
    }

    private String makeSplitRegex() {
        return makeSplitRegex("");
    }

    private String makeSplitRegex(String customDelimiter) {
        return "[,\\n" + customDelimiter + "]";
    }

    private int getSumFromString(String numbersString, String customDelimiter) throws NumberStringFormatException {
        String[] fragments = numbersString.split(makeSplitRegex(customDelimiter));
        int result = 0;
        for (String fragment: fragments) {
            result += parseInt(fragment);
        }
        return result;
    }

    private static class NumbersStringWithDelimiter {
        public final String numbersString;
        public final String customDelimiter;

        public NumbersStringWithDelimiter(String numbersString, String customDelimiter) {
            this.numbersString = numbersString;
            this.customDelimiter = customDelimiter;
        }
    }

}
