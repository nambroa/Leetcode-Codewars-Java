package LeetCode;

/*
169. Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element
always exists in the array.



Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109

 */

import java.util.Collections;
import java.util.HashMap;

/*
Keep in mind that solutions here are based on problem constraints. Input array is never null nor empty!

Initial version is pretty simple. Just count all the numbers and the time each appears with a hashmap and then returns
the biggest value of that hashmap. This takes linear time and linear space (because of the hashmap).

The follow up question requires constant space, so no memoization is allowed.

This is not a solvable problem in an interview, as the algorithm that solves it comes from a paper and is titled the
Boyer-Moore Majority Vote Algorithm. The idea is to have 2 counters, count and major. We move through the array and if
the current num[i] coincides with the major, we increase count, otherwise we decrease it. If count reaches 0, we reset
the major to the current num. The basic principle behind the algorithm is that the majority ALWAYS EXISTS, so it will
always end up with the biggest count number, thus it will always be the final major number stored in the variable
of the same name. Both solutions are posted below for clarity, but I wouldn't expect anyone to know the second one.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        return Collections.max(countMap.values());
    }

    public int majorityElementConstantSpace(int[] nums) {
        int count = 1, major = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                major = nums[i];
            } else if ((nums[i] == major)) {
                count++;
            } else {
                count--;
            }
        }

        return major;

    }

}
