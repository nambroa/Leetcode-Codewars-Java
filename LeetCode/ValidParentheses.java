package LeetCode;

/*
20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {
    public static boolean isValidRecu(String s, Integer i, List<Character> memo) {
        if (i == s.length()) {
            return memo.size() == 0;
        }

        Character par = s.charAt(i);
        switch (par) {
            case '(', '[', '{' -> {
                memo.add(par);
                return isValidRecu(s, i + 1, memo);
            }
            case ')' -> {
                if (memo.size() == 0 || memo.get(memo.size()-1) != '(') {
                    return false;
                }
                memo.remove(memo.size()-1);
                return isValidRecu(s, i+1, memo);
            }
            case ']' -> {
                if (memo.size() == 0 || memo.get(memo.size()-1) != '[') {
                    return false;
                }
                memo.remove(memo.size()-1);
                return isValidRecu(s, i+1, memo);
            }
            case '}' -> {
                if (memo.size() == 0 || memo.get(memo.size()-1) != '{') {
                    return false;
                }
                memo.remove(memo.size()-1);
                return isValidRecu(s, i+1, memo);
            }
        }
        return false; // Will never execute since string is always comprised of only parenthesis.
    }

    public static boolean isValid(String s) {
        return isValidRecu(s, 0, new ArrayList<>());
    }

}
