import java.util.List;

public class StringCalculator {

    public int add(String operation) throws WrongOperationFormat {
        if (operation == null || operation.isEmpty()) {
            return 0;
        } else {
            return addOperationNotEmpty(operation);
        }
    }

    private int addOperationNotEmpty(String operation) throws WrongOperationFormat {
        NumberString numberString = new NumberString(operation);
        List<Integer> parsedNumbers = numberString.getParsedNumbers();
        return makeSum(parsedNumbers);
    }

    private int makeSum(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
