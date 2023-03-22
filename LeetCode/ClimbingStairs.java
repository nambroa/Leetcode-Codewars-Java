package LeetCode;

/*
70. Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:
1 <= n <= 45
 */

/*
This is a dynamic programming question. You can tell because it says "in how many distinct ways" requiring to count
ALL possible ways.

stairs(3) = stairs(2) + stairs(1) = stairs(1) + stairs(1) + stairs(1) = 3.

We can see that, for a non trivial N, we will do some repeated calculations. So its convenient to memoize results
each time we resolve a specific N. For example:

stairs(5) would not be memoized, so we do memo(5) = stairs(4) + stairs(3).
stairs(4) would not be memoized so we do memo(4) = stairs(3) + stairs(2) and so on.

This allows us to skip additional calculations that we have done before. We only calculate all the numbers between
1 and N. Each calculation is done in constant time, so the total time complexity is linear in relation to N so O(N).
Space complexity is also linear since this has a recursive stack of N and the memo structure hashmap also has size N.
 */

import java.util.HashMap;

public class ClimbingStairs {
    private int climbStairsRec(int n, HashMap<Integer, Integer> memo) {
        if (n == 1 || n == 2 || n == 3) {
            memo.put(n, n);
        }
        if (!memo.containsKey(n)) {
            // Recursion in case N is not memoized yet.
            memo.put(n, climbStairsRec(n - 1, memo) + climbStairsRec(n - 2, memo));
        }
        return memo.get(n);
    }

    public int climbStairs(int n) {
        return climbStairsRec(n, new HashMap<>());
    }
}
