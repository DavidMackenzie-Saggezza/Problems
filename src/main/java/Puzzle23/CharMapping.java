package Puzzle23;

import java.util.HashMap;

public class CharMapping {
    public static boolean existsMapping(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Character> mapping = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (mapping.containsKey(s1.charAt(i))) {
                if (mapping.get(s1.charAt(i)) != s2.charAt(i)) {
                    return false;
                }
            }
            else {
                mapping.put(s1.charAt(i), s2.charAt(i));
            }
        }
        return true;
    }
}
