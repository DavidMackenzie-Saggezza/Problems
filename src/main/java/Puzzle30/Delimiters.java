package Puzzle30;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiters {
    public static String reverseWords(String string) {
        boolean startsWithDelimiter = Pattern.matches("^[^a-zA-Z0-9].*", string);

        Stack<String> allWords = new Stack<>();
        Matcher m = Pattern.compile("[a-zA-Z0-9]+")
                .matcher(string);
        while (m.find()) {
            allWords.add(m.group());
        }

        Deque<String> allDelimiters = new ArrayDeque<>();
        Matcher ed = Pattern.compile("[^a-zA-Z0-9]+")
                .matcher(string);
        while (ed.find()) {
            allDelimiters.add(ed.group());
        }

        StringBuilder reversed = new StringBuilder();

        while (!allWords.isEmpty() && !allDelimiters.isEmpty()) {
            if (startsWithDelimiter) {
                reversed.append(allDelimiters.pop());
                reversed.append(allWords.pop());
            }
            else {
                reversed.append(allWords.pop());
                reversed.append(allDelimiters.pop());
            }
        }

        while (!allWords.isEmpty()) {
            reversed.append(allWords.pop());
        }
        while (!allDelimiters.isEmpty()) {
            reversed.append(allDelimiters.pop());
        }

        return reversed.toString();
    }
}
