package com.wei.leetcode.f500;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution_20 {

    public static void main(String[] args) {

        Solution_20 solution = new Solution_20();
        System.out.println(solution.isValid("{}{{}{{}{}"));
    }

    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(']', '[');
            put('}', '{');
            put(')', '(');
        }};

        Deque<Character> characters = new ArrayDeque<>();

        for (int i = 0; i < charArray.length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (characters.isEmpty() || characters.peek() != map.get(c)) {
                    return false;
                }
                characters.pop();
            } else {
                characters.push(c);
            }
        }

        return characters.isEmpty();
    }
}


