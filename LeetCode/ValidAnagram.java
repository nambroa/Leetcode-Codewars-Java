package LeetCode;

/*
242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false


Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */

import java.util.HashMap;
import java.util.Map;

/*
We can create a hashmap that counts the letters of s. Then subtract from the same hashmap the letters of t.
If we see that any letter count goes below 0 we return False. Finally, we check all the values in the hashmap.
They should all be 0 for an anagram. Return true if it is so, otherwise false.
 */

/*
As far as complexity goes, we use 2 forEach loops, one for each string. Then we do a noneMatch for the values of the map.
The complexity is O(S) + O(T) + O(max(S,T)) with T=length of t and S=length of s.
We can reduce it to O(max(S,T)) since O(S) and O(T) and lower or equal than O(max(S,T)).
 */

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> letterCount = new HashMap<>();
        s.chars().forEach(c ->
                letterCount.put((char) c, letterCount.getOrDefault((char) c, 0)+1));
        t.chars().forEach(c ->
                letterCount.put((char) c, letterCount.getOrDefault((char) c, 0)-1));

        return letterCount.values().stream().noneMatch(count -> count != 0);
    }

}
