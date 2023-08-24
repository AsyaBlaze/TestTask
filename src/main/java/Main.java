import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static String calc(String input) {
        Pattern pattern = Pattern.compile("(^[1-9]|10) ([+\\-*/]) ([1-9]|10)\\s*$");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find())
            throw new IllegalArgumentException("Input does not match the expected format");
        int num1 = Integer.parseInt(matcher.group(1));
        int num2 = Integer.parseInt(matcher.group(3));
        return getResult(num1, num2, matcher.group(2));
    }

    static String getResult(int num1, int num2, String operator) {
        int rsl = -1;
        switch (operator) {
            case "+" -> rsl = num1 + num2;
            case "-" -> rsl = num1 - num2;
            case "*" -> rsl = num1 * num2;
            case "/" -> rsl = Math.round(num1/num2);
        }
        return String.valueOf(rsl);
    }
}

