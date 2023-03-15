package LeetCode;

import java.util.HashSet;

/*
704. Binary Search

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search
target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1


Constraints:
1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.

 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        return binarySearchRec(nums, target, 0, nums.length, new HashSet<>());
    }

    private int binarySearchRec(int[] nums, int target, int start, int end, HashSet<Integer> visited) {
        int middle = (start + end) / 2;

        int num = nums[middle];
        if (visited.contains(num)) {
            return -1; // Already visited that number, we are looping therefore the target is not in nums.
        }

        visited.add(num);
        if (num == target) {
            return middle;
        }
        if (num < target) {
            return binarySearchRec(nums, target, middle, end, visited);
        }
        return binarySearchRec(nums, target, start, middle, visited); // At this point num > target.
    }
}

