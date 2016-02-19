import java.util.ArrayList;
import java.util.List;

public class StringCalculator {


    public int add(String operation) {
        if (operation == null || operation.isEmpty()) {
            return 0;
        } else {
            return add_operationNotEmpty(operation);
        }
    }

    private int add_operationNotEmpty(String operation) {
        NumberString numberString = new NumberString(operation);
        List<Integer> numbers = numberString.getParsedNumbers();
        return makeSum(numbers);
    }

    private int makeSum(List<Integer> numbers) {
        int result = 0;
        for (int i: numbers) {
            result += i;
        }
        return result;
    }


}
