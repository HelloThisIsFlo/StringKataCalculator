import java.util.ArrayList;
import java.util.List;

public class NumberString {

    private final String operation;
    private String delimiter;
    private String numbers;

    private List<Integer> parsedNumbers;

    public NumberString(String operation) throws WrongOperationFormat {
        this.operation = operation;
        extractDelimiterAndNumbers();
        parseNumbers();
    }

    private void extractDelimiterAndNumbers() {
        if (hasDelimiter()) {
            delimiter = operation.substring(2, 3);
            numbers = operation.substring(4);
        } else {
            delimiter = "";
            numbers = operation;
        }
    }

    private boolean hasDelimiter() {
        return operation.startsWith("//");
    }

    private void parseNumbers() throws WrongOperationFormat {
        String[] segments = numbers.split(makeSplitRegex());
        parsedNumbers = new ArrayList<>(segments.length);
        for (String segment : segments) {
            parsedNumbers.add(parseInt(segment));
        }
    }

    private String makeSplitRegex() {
        return "[," + delimiter + "\n]";
    }

    private int parseInt(String toParse) throws WrongOperationFormat {
        try {
            return Integer.parseInt(toParse);
        } catch (NumberFormatException e) {
            throw new WrongOperationFormat(
                    "Wrong format : " + toParse + "\nPlease check the format of the operation string!", e
            );
        }
    }

    public List<Integer> getParsedNumbers() {
        return parsedNumbers;
    }

}
