package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations
of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150
combinations for the given input.


Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []


Constraints:
1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40

 */

/*
When I see something like "return all combinations/permutations" my mind goes immediately to dynamic programming.

In this case, given [2,3,6,7] and target 7, I should return [[2,2,3],[7]]. A naive solution would be to explore all
possible combinations.

We can explore all the branches of the decision tree [2,3,6,7]. 7 we end exploring since we found target.
6 we have [2,3,6,7], all go over target, so no solutions there.
3 we have [2,3,6,7] meaning [3,2][3,3][3,6][3,7] and 2 ends up with [2,2][2,3][2,6][2,7]. We have a duplicate here in
the next step [2,2,3] and [2,3,2]. So this naive approach works but we end up with duplicates.

The solution is to modify the decision tree. We split the initial decisions in two.
One contains the number [2] and another is a currently empty array with a solution that will be formed from [3,6,7].
So the paths can never repeat themselves since they use different numbers.
Following the first path of [2], we have a new path with [2,2] that will lead to all combinations that include [2,2]
The other path that splits from the first one will on purpose never contain [2,2] so as to avoid duplicates.

Doing that solution we can get all combination without repeats. We do have to explore basically all combinations that
can sum up to target, we only discard solution when they exceed target or we are left with an empty array.

space complexity is O(target val / smallest val in candidates)
b/c max depth of the tree is when it keeps adding the smallest element to the combination until it hits or exceeds target.

time: O(2^target) since each step in the tree is about including or excluding one number (2 choices). Since the min
number is 1, each step can reduce target by one, so in total we need to take target steps to reach target. So the max
possible depth of the recursion tree is target.
 */

class SolutionCombination_Sum {

    public void dfs(List<List<Integer>> res, int[] candidates, int i, List<Integer> curCombination, int curSum, int target){
        // Found a possible combination. Copy the combination and add it to res. We want a copy since we will add more
        // numbers to that list in future iterations that are not part of the current solution combination.
        if(curSum == target){
            res.add(List.copyOf(curCombination));
            return;
        }

        // Impossible to make successful comb. since index is oob or current sum is bigger already than target.
        if(i >= candidates.length || curSum > target){
            return;
        }

        // Recursive step: Choose to include candidates[i] in current combination or not.
        curCombination.add(candidates[i]);
        dfs(res, candidates, i, curCombination, curSum+candidates[i] , target);
        // Other decision: NOT include candidates[i], last element of the combination.
        curCombination.remove(curCombination.size()-1);

        // Move on to the next number in candidates.
        dfs(res, candidates, i+1, curCombination, curSum, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(res, candidates, 0, new ArrayList<>(), 0, target);
        return res;
    }
}
