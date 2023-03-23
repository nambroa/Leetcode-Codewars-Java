package LeetCode;

/*
409. Longest Palindrome

Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome
that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Example 1:
Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.


Constraints:
1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
 */

/*
To build a palindrome, you need all letters to be a multiple of 2 EXCEPT for 1 at most.

We can begin by making a hashmap counting all the letters. All the letters that appear an even number of times can then
be added to the longest palindrome count. The uneven letters can be added to, but we must substract one from their
count to make them even. Finally, we need to add 1 if we found any uneven letters, since palindromes tolerate 1
uneven letter at most. So if we find ccc in the string, we need to add 2+1, not 2.

 */

import java.util.HashMap;
import java.util.Optional;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        int longestPalindromeLength = 0;

        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        longestPalindromeLength += countMap.values().stream().mapToInt(count -> count % 2 == 0 ? count : count-1).sum();
        int foundUnevenLetter = countMap.values().stream().anyMatch(count -> count % 2 == 1) ? 1 : 0;

        return longestPalindromeLength + foundUnevenLetter;
    }
}


