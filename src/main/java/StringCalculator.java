import java.util.List;

public class StringCalculator {

    private List<Integer> currentNumbers;

    public int add(String operation) throws OperationFormatException, NegativeNumberNotAllowed {
        if (operation == null || operation.isEmpty()) {
            return 0;
        } else {
            return add_operationNotEmpty(operation);
        }
    }

    private int add_operationNotEmpty(String operation) throws OperationFormatException, NegativeNumberNotAllowed {
        OperationParser operationParser = new OperationParser(operation);
        currentNumbers = operationParser.getParsedNumbers();
        return makeSum();
    }

    private int makeSum() throws NegativeNumberNotAllowed {
        List<Integer> curatedNumbers = curateNumbers();
        int result = 0;
        for (int i: curatedNumbers) {
                result += i;
        }
        return result;
    }

    private List<Integer> curateNumbers() throws NegativeNumberNotAllowed {
        NumberCurator curator = new NumberCurator(currentNumbers);
        curator.validate();
        return curator.getCuratedNumbers();
    }
}
