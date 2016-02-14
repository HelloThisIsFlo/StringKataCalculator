public class StringCalculator {


    public int add(String numbersString) {
        if (numbersString == null || numbersString.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(numbersString);
        }
    }


}
