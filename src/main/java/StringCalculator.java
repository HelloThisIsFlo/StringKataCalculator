import java.util.List;

public class StringCalculator {


    public int add(String operation) throws OperationFormatException, NegativeNumberNotAllowed {
        if (operation == null || operation.isEmpty()) {
            return 0;
        } else {
            return add_operationNotEmpty(operation);
        }
    }

    private int add_operationNotEmpty(String operation) throws OperationFormatException, NegativeNumberNotAllowed {
        OperationParser operationParser = new OperationParser(operation);
        List<Integer> numbers = operationParser.getParsedNumbers();
        return makeSum(numbers);
    }

    private int makeSum(List<Integer> numbers) throws NegativeNumberNotAllowed {
        int result = 0;
        for (int i: numbers) {
            checkIfNotNegative(i);
            result += i;
        }
        return result;
    }

    private void checkIfNotNegative(int i) throws NegativeNumberNotAllowed {
        if (i < 0) {
            throw new NegativeNumberNotAllowed();
        }
    }
}
