import java.util.ArrayList;
import java.util.List;

public class OperationParser {
    private final String operation;

    private String delimiter;
    private String numbers;

    public OperationParser(String operation) {
        this.operation = operation;
        extractDelimiter();
        extractNumbers();
    }

    private void extractDelimiter() {
        if (hasDelimiter()) {
            delimiter = operation.substring(2,3);
        } else {
            delimiter = "";
        }
    }

    private void extractNumbers() {
        if (hasDelimiter()) {
            numbers = operation.substring(4);
        } else {
            numbers = operation;
        }
    }

    private boolean hasDelimiter() {
        return operation.startsWith("//");
    }

    public List<Integer> getParsedNumbers() throws OperationFormatException {
        String[] fragments = numbers.split(makeSplitRegex());
        List<Integer> parsedNumbers = new ArrayList<>(fragments.length);
        for (String fragment: fragments) {
            parsedNumbers.add(parseInt(fragment));
        }

        return parsedNumbers;
    }

    private String makeSplitRegex() {
        return "[," + delimiter + "\n]";
    }

    private int parseInt(String intString) throws OperationFormatException {
        try {
            return Integer.parseInt(intString);
        } catch (NumberFormatException e) {
            throw new OperationFormatException("Please check operation format!", e);
        }
    }
}
