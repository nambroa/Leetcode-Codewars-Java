package LeetCode;

/*
443. String Compression

Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.
You must write an algorithm that uses only constant extra space.


Example 1:
Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

Example 2:
Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.

Example 3:
Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".


Constraints:

1 <= chars.length <= 2000
chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
 */

/*
The main problem here is the constant extra space requirement. We must perform alterations of the char array in place.
We must also perform these alterations AS we traverse the array in order for us to keep the time complexity linear.

Let's take the example aabbccc. We begin at a and store it in a primitive char. We also store an int counting the number
of times it appeared. So it would be a 1 for now. We move on and do a 2. We then arrive at b and realize it is different
than a. If count is 1, we do nothing. If count is bigger than 1, we must delete all occurences of that letter
and replace those with letter and number of times it appeared. Keep in mind if the length is longer than 10 split it.

So we need to also store start index and end index of the things to delete. And we delete when we find a new letter.
*/

public class StringCompression {
    public int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }

        char cur = chars[0];
        int count = 1, startIndex = 0, endIndex = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == cur) {
                count++;
            } else {
                // Add the char to the start position. and add each digit of count to the array.
                chars[startIndex] = cur;
                for (char c : Integer.toString(count).toCharArray()) {
                    startIndex++;
                    chars[startIndex] = c;
                }
                // Update start index.
                startIndex++; // Pointing to the next space after the last digit of count.
                cur = chars[i]; // New char
                count = 1;
            }
        }

        // Do last iteration manually.
        chars[startIndex] = cur;
        String strNum = Integer.toString(count);
        for (char c : strNum.toCharArray()) {
            startIndex++;
            chars[startIndex] = c;
        }

        return startIndex + 1;
    }
}