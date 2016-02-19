import java.util.ArrayList;
import java.util.List;

public class NumberString {
    private final String operation;

    public NumberString(String operation) {
        this.operation = operation;
    }

    public List<Integer> getParsedNumbers() {

        String[] fragments = operation.split(",");
        List<Integer> parsedNumbers = new ArrayList<>(fragments.length);
        for (String fragment: fragments) {
            parsedNumbers.add(Integer.parseInt(fragment));
        }

        return parsedNumbers;
    }
}
