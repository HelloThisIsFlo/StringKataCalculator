import java.util.ArrayList;
import java.util.List;

public class OperationParser {
    private final String operation;

    public OperationParser(String operation) {
        this.operation = operation;
    }

    public List<Integer> getParsedNumbers() throws OperationFormatException {

        String[] fragments = operation.split(",");
        List<Integer> parsedNumbers = new ArrayList<>(fragments.length);
        for (String fragment: fragments) {
            parsedNumbers.add(parseInt(fragment));
        }

        return parsedNumbers;
    }

    private int parseInt(String intString) throws OperationFormatException {
        try {
            return Integer.parseInt(intString);
        } catch (NumberFormatException e) {
            throw new OperationFormatException("Please check operation format !", e);
        }
    }
}
