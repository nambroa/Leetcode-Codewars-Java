package LeetCode;

/*
238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product
of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.


Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */

/*
The idea is to have 2 pointers, prefix and suffix. Prefix begins at the beginning and suffix begins at the end.
Both with the value of 1. Every item in the result arr can be expressed by a multiplication of prefix and suffix
related to the items that are before and after it in the original array.

For example, nums [1,2,3,4] and output [24,12,8,6].
24 is prefix 1 multiplied by suffix 4*3*2
12 is prefix 1*1 multiplied by suffix 4*3
etc..

The output array is initialized as [1,1,1,1]. We do a loop through it.
First iteration we multiply the first num by the prefix 1, and we multiply the last num by the suffix 1.
Second iteration we multiply the second num by the prefix 1*1, and third num by suffix 1*4.
Third iteration we multiply third num by prefix 1*1*2 and second num by suffix 1*4*3.
Fourth iteration we multiply last num by prefix 1*1*2*3 and first num by suffix 1*4*3*2

We then return the output array.
 */

/*
Time complexity is linear since we iterate through array once doing only constant time operations.
The creation of the output array filled with 1's is also linear in time complexity.

Space complexity is constant since we only use the array we want to return anyways.
 */

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);

        int prefix = 1, prefPos = 0, suffix = 1, sufPos = nums.length-1;

        while(prefPos < nums.length){
            output[prefPos] *= prefix;
            output[sufPos] *= suffix;

            prefix *= nums[prefPos];
            suffix *= nums[sufPos];

            prefPos++;
            sufPos--;
        }

        return output;
    }
}
