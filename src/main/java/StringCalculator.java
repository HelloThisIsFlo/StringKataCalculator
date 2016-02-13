public class StringCalculator {


    /**
     * Return the sum of numbers contained in a String.
     *
     * Format :
     *  * The numbers should be separated by a comma ("1,432,4")
     */
    public int add(String numbers) throws NumberStringFormatException{
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        } else {
            return getSumFromString(numbers);
        }
    }

    private int getSumFromString(String numbersString) throws NumberStringFormatException {
        String[] fragments = numbersString.split(makeRegex());
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

    private String makeRegex() {
        return "[,\\n]";
    }

}
