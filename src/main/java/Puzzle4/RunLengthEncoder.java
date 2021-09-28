package Puzzle4;

public class RunLengthEncoder {
    public static String encode(String input) {
        if (input.equals("")) {
            return "";
        }
        String encoded = "";
        int index = 0;
        int count = 0;
        char temp = input.charAt(0);
        while (index < input.length()) {
            if (input.charAt(index) == temp) {
                count++;
            }
            else {
                encoded = encoded.concat(count + String.valueOf(temp));
                count = 1;
                temp = input.charAt(index);
            }
            index++;
        }
        encoded = encoded.concat(count + String.valueOf(temp));
        return encoded;
    }

    public static String decode(String input) {
        if (input.equals("")) {
            return "";
        }
        String decoded = "";
        int index = 0;
        String count = "";
        while (index < input.length()) {
            if (Character.isDigit(input.charAt(index))) {
                count = count.concat(String.valueOf(input.charAt(index)));
            }
            else {
                decoded = decoded.concat(String.valueOf(input.charAt(index)).repeat(Integer.parseInt(count)));
                count = "";
            }
            index++;
        }
        return decoded;
    }
}
