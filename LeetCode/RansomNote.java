package LeetCode;

/*
383. Ransom Note
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using
the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.


Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true


Constraints:
1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
 */

import java.util.HashMap;
import java.util.Objects;

/*
We can first store the letters from magazine on a map. Like so {a: 2, b:1}. We then iterate through ransomNote's chars
and we delete from the map each time. If we make it to the end of ransomNote, it means that it can be constructed.
If at some point any map counter goes below 0, it cannot be constructed.

Space complexity is linear in terms of the longest string between ransomNote and magazine, since the map will contain
at most that amount of entries assuming unique chars in worst case scenario.

Time complexity is also linear in terms of the longest string since we iterate both and we do it only once.
 */

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (Objects.equals(magazine, "")) {
            return Objects.equals(ransomNote, "");
        }

        HashMap<Character, Integer> countMap = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) - 1);
            if (countMap.get(c) < 0) {
                return false;
            }
        }

        return true;
    }

}
