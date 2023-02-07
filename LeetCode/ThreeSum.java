package LeetCode;

import java.util.*;

/*
15. 3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:
3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */

/*
To do this exercise you must do TwoSum first. The idea is to solve twosum for each member of the input array with the
target number being 0 in this case. So, parsing the problem in terms of twosum would be like this:

Example: [-1,0,1,2,-1,-4]. First number is -1, and you solve twoSum([0,1,2,-1,-4]) with target=1
Next number is 0, you solve twoSum([1,2,-1,-4]) with target=0.

You can have duplicate triplets like [-1,0,1] and [0,1,-1] so we will store answers in a set before passing everything
to the expected list of lists format.

The complexity is thus cuadratic in terms of array length. You have to iterate the whole array and twoSum is also linear
complexity. So O(N*N) = O(N^2)
 */

public class ThreeSum {
    public void twoSum(int[] nums, int target, Set<List<Integer>> res) {
        Map<Integer, Integer> targetComplements = new HashMap<>();
        for (int num : nums) {
            if (targetComplements.containsKey(target - num)) {
                List<Integer> indexPair = new ArrayList<>();
                indexPair.add(-target); // The original number used to call twoSum with
                indexPair.add(target-num);
                indexPair.add(num);
                Collections.sort(indexPair);
                res.add(indexPair);
            }else{
                targetComplements.put(num, 1);
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int[] subArr = Arrays.stream(nums, i+1, nums.length).toArray();

            twoSum(subArr, -num, res);
        }
        return res.stream().toList();
    }

}
