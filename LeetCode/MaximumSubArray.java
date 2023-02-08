package LeetCode;

/*
53. Maximum Subarray

Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
 */

/*
The idea for maximum subarray is simple. Have a counter for the current sum, starting at 0.
Iterate through the subarray, adding the current number to the counter. If the counter goes below 0, reset it, because
it means that up until that point, the sum is negative. So it is just better to start a new subarray sum from the
current position.
 */

/*
Complexity is linear since we have to iterate through the entire array and we only do constant time complexity
operations on the loop.
 */
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxSum = nums[0];
        for (int num : nums) {
            curSum += num;
            maxSum = Math.max(curSum, maxSum);
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }

}
