import java.util.List;

public class StringCalculator {


    public int add(String operation) throws OperationFormatException {
        if (operation == null || operation.isEmpty()) {
            return 0;
        } else {
            return add_operationNotEmpty(operation);
        }
    }

    private int add_operationNotEmpty(String operation) throws OperationFormatException {
        OperationParser operationParser = new OperationParser(operation);
        List<Integer> numbers = operationParser.getParsedNumbers();
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
