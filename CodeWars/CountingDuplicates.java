package CodeWars;

import java.util.HashMap;
import java.util.Map;

/*
Count the number of Duplicates
Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits
that occur more than once in the input string.

The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.

Example
"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice


 */

/*
We will count each individual char in a map containing all the chars of the text and how many times each one appears.
Then we will use a reduce function on the map's values to only count the chars that appeared more than once, and return
that result.
 */

/*
N = text.length()
Complexity is O(N) for creating the map that counts the chars. Then the reduce function is applied to all the map's
values, which means that in worst case scenario is another O(N) where the text has all unique chars. The reduce function
is constant on each iteration.

Final complexity is thus O(N) time and O(N) space.
 */

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        Map<Character, Integer> countsMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            countsMap.put(Character.toLowerCase(c), countsMap.getOrDefault(Character.toLowerCase(c), 0) + 1);
        }
        return countsMap.values().stream()
                .reduce(0, (duplicates, charCount) -> charCount > 1 ? duplicates+1 : duplicates);
    }

}
