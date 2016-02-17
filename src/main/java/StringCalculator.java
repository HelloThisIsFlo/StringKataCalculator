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
        NumberString delimiterAndNumbers = new NumberString(numbersString);
        List<Integer> numbers = delimiterAndNumbers.getParsedNumbers();
        return makeSum(numbers);
    }

    private int makeSum(List<Integer> numbers) {
        int result = 0;
        for (Integer i: numbers) {
            result += i;
        }
        return result;
    }

}
