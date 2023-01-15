package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

  Example 1:
  Input: nums = [1,2,3]
  Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

  Example 2:
  Input: nums = [0,1]
  Output: [[0,1],[1,0]]

  Example 3:
  Input: nums = [1]
  Output: [[1]]

  Constraints:
  1 <= nums.length <= 6
  -10 <= nums[i] <= 10
  All the integers of nums are unique.
 */

/*
 * I think that this is a DP solution. So we need to think about the base case first.
 * Let's take the array [1,2,3]. The base case could be [1] which has a permutation of [1].
 *
 * We begin with the complete array [1,2,3]. The decision tree here could be the creation of three new arrays
 * One for each unique element of the original array. Basically a loop iterating through the array.
 *
 * [1,2,3] --> [1,..] [2,..] [3,..]
 * In each call we add that element to the new list. For the [1,..] I still need to add [2,3]. The possible permutations
 * are [1,2,3],[1,3,2]. So I can call a recursive function with [2,3] and [1,..]. Here we create [1,2,..] and [1,3,..]
 * And call recursively with [1,2,..] [3] and [1,3,..] [2] respectively. We arrive at the base case, which is just add
 * the remaining array number to the solution array and return the solution array.
 *
 * The time complexity is O(P) where P is the total amount of permutations. Space is O(P) without counting the result
 * array since the recursion stack is of length P.
 */

class SolutionPermutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsL = Arrays.stream(nums).boxed().toList();
        if (nums.length == 1) {
            result.add(numsL);
            return result;
        }

        return permuteRecu(result, numsL, new ArrayList<>());
    }

    private List<List<Integer>> permuteRecu(List<List<Integer>> result, List<Integer> numsL, List<Integer> partial) {
        // Base case.
        if (numsL.size() == 1) {
            partial.add(numsL.get(0));
            result.add(partial);
            return result;
        }

        for (Integer num : numsL) {
            // Add the current element to the partial result, and remove it from nums for that iteration only.
            List<Integer> newPartial = new ArrayList<>(partial);
            newPartial.add(num);
            List<Integer> newNums = new ArrayList<>(numsL);
            newNums.remove(num);
            permuteRecu(result, newNums, newPartial);
        }
        return result;
    }
}