package LeetCode;

/*
217. Contains Duplicate

Given an integer array nums, return true if any value appears at least twice in the array, and return false
if every element is distinct.


Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true


Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109

*/

/*
Pretty simple algorithm. We iterate through the numbers array and add each to a set. The add method in set returns
false if the item IS in the set. So, in each addition, we check if the return value is false, meaning the array has
a duplicate. In that case we return false. If we manage to iterate through the whole nums array, it means there are
no duplicates and thus we return true.
 */

/*
Time complexity is linear since we iterate the nums array once and we perform constant operations in each iteration.
Space complexity is linear since we use a set that, worst case scenario, will contain all the items from the nums arr.
 */


import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> nonRepeatedNums = new HashSet<>();
        for (int num : nums) {
            if (!nonRepeatedNums.add(num)) {
                return true;
            }
        }
        return false;
    }

}
