public class StringCalculator {


    /**
     * Return the sum of numbers contained in a String.
     *
     * Format :
     *  * The numbers should be separated by a comma ("1,432,4")
     */
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        } else {
            return getSumFromString(numbers);
        }
    }

    private int getSumFromString(String numbersString) {
        String[] fragments = numbersString.split(",");
        int result = 0;
        for (String fragment: fragments) {
            result += Integer.parseInt(fragment);
        }


        return result;
    }

}
