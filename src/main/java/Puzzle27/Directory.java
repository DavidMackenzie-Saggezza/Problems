package Puzzle27;

import java.util.Stack;
import java.util.regex.Pattern;

public class Directory {
    public static long longestPath(String directory) {
        int maxAbsolutePathLength = 0;
        Stack<String> relativeFilepath = new Stack<>();

        String[] filepaths = directory.split("\n");

        for (String filepath : filepaths) {
            int numTabs = (int) Pattern.compile("\t").matcher(filepath).results().count();
            if (numTabs < relativeFilepath.size()) {
                for (int i = 0; i < relativeFilepath.size() - numTabs; i++) {
                    relativeFilepath.pop();
                }
            }
            if (filepath.matches(".*[.][a-zA-Z0-9]+")) {
                String absoluteFilepath = String.join("/", relativeFilepath).concat("/".concat(filepath.strip()));
                maxAbsolutePathLength = Math.max(maxAbsolutePathLength, absoluteFilepath.length());
            } else {
                relativeFilepath.push(filepath.strip());
            }
        }
        return maxAbsolutePathLength;
    }
}