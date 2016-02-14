import java.util.ArrayList;
import java.util.List;

public class StringCalculator {


    public int add(String numbersString) {
        if (numbersString == null || numbersString.isEmpty()) {
            return 0;
        } else {
            List<Integer> numbers = parseNumbers(numbersString);
            return makeSum(numbers);
        }
    }

    private List<Integer> parseNumbers(String numbersString) {
        String[] fragments = numbersString.split(",");
        List<Integer> numbers = new ArrayList<>(fragments.length);
        for (String fragment: fragments) {
            numbers.add(Integer.parseInt(fragment));
        }
        return numbers;
    }

    private int makeSum(List<Integer> numbers) {
        int result = 0;
        for (Integer i: numbers) {
            result += i;
        }
        return result;
    }


}
