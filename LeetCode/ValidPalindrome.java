package LeetCode;

/*
125. Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */

/*
First, we need to remove all non-alphanumeric characters from the string. This takes linear time complexity.
Then, we can have 2 pointers. One at the beginning and one at the end. We move them at the same time, and we compare
the chars in each position, they have to be the same.
We stop when the pointers cross. Each comparison is done in forced lowercase to prevent A!=a case.

Total time complexity is thus linear in terms of the length of the string. Space complexity is also linear since we
need a new string that has the whitespaces removed.
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String cleanedS = s.replaceAll("[^a-zA-Z0-9]", "");

        int i = 0;
        int j = cleanedS.length() - 1;
        while (i < j) {
            if (Character.toLowerCase(cleanedS.charAt(i)) != Character.toLowerCase(cleanedS.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
