import java.util.ArrayList;
import java.util.List;

/**
 * Curate a list of Numbers.
 * Validates the list to ensure all numbers are allowed.
 * Ignores numbers that do not respect certain condition.
 */
public class NumberCurator {

    private final List<Integer> numbers;
    private List<Integer> curatedNumbers = new ArrayList<>();

    private boolean hasNegativeNumbersFlag = false;

    private int currentNumber;

    public NumberCurator(List<Integer> numbers) {
        this.numbers = numbers;
        curateNumbers();
    }

    private void curateNumbers() {
        for (int i: numbers) {
            currentNumber = i;
            flagIfNegative();
            addToCuratedIfValid();
        }
    }

    private void flagIfNegative() {
        if (currentNumberIsNegative()) {
            hasNegativeNumbersFlag = true;
        }
    }

    private void addToCuratedIfValid() {
        if (!shouldBeIgnored()) {
            curatedNumbers.add(currentNumber);
        }
    }

    private boolean shouldBeIgnored() {
        return currentNumberIsTooBig() || currentNumberIsNegative();
    }

    private boolean currentNumberIsNegative() {
        return currentNumber < 0;
    }

    private boolean currentNumberIsTooBig() {
        return currentNumber >= 1000;
    }

    public void validate() throws NegativeNumberNotAllowed {
        if (hasNegativeNumbersFlag) {
            throw new NegativeNumberNotAllowed();
        }
    }

    public List<Integer> getCuratedNumbers() {
        return curatedNumbers;
    }

}
