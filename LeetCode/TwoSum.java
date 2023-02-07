package LeetCode;

/*
1. Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

 */

import java.util.HashMap;
import java.util.Map;

/*
We need to return the indexes of two numbers in the array that add up to target. The solution will always exist.

We need to compare all numbers against each other, making sure that we only compare once. We can use a map
to do this in linear time. It's a trick known as a complements map.

Taking the example [2,7,11,15]. We see the 2 and check the set if its target complement is there. The target complement
is the number that is required to sum up to target. This means 7. Set is empty, so we add 2. We move on, and see the
number 7. We search the set for the target complement of 7, which is 2. Its there, so we return current index and
map[2], which contains the index of 2.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> targetComplements = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (targetComplements.containsKey(target - nums[i])) {
                return new int[]{targetComplements.get(target - nums[i]), i};
            }
            targetComplements.put(nums[i], i);
        }
        return null;
    }
}
