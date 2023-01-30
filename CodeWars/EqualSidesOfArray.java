package CodeWars;

/*
You are going to be given an array of integers. Your job is to take that array and find an index N
where the sum of the integers to the left of N is equal to the sum of the integers to the right of N.
If there is no index that would make this happen, return -1.

For example:

Let's say you are given the array {1,2,3,4,3,2,1}:
Your function will return the index 3, because at the 3rd position of the array,
the sum of left side of the index ({1,2,3}) and the sum of the right side of the index ({3,2,1}) both equal 6.

Let's look at another one.
You are given the array {1,100,50,-51,1,1}:
Your function will return the index 1, because at the 1st position of the array,
the sum of left side of the index ({1}) and the sum of the right side of the index ({50,-51,1,1}) both equal 1.

Last one:
You are given the array {20,10,-80,10,10,15,35}
At index 0 the left side is {}
The right side is {10,-80,10,10,15,35}
They both are equal to 0 when added. (Empty arrays are equal to 0 in this problem)
Index 0 is the place where the left side and right side are equal.

Note: Please remember that in most programming/scripting languages the index of an array starts at 0.

Input:
An integer array of length 0 < arr < 1000. The numbers in the array can be any integer positive or negative.

Output:
The lowest index N where the side to the left of N is equal to the side to the right of N.
If you do not find an index that fits these rules, then you will return -1.

Note:
If you are given an array with multiple answers, return the lowest correct index.
 */

import java.util.Arrays;

/*
Let's begin walking through the example {1,2,3,4,3,2,1} to find the answer. We know the answer is index 3, number 4.
We can do a greedy algorithm where we check, for every number, the sum to the left and the sum to the right.
This is useful because, in the case that the array presents multiple solutions, we need to return the lowest index.

We can abstract the sum to the left and right to another function.
 */
public class EqualSidesOfArray {
    public static int sumItemsBetween(int start, int end, int[] arr) {
        // Goes from start to end-1
        return Arrays.stream(arr, start, end)
                .sum();
    }

    public static int findEvenIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int leftSum = sumItemsBetween(0, i, arr); // IntStream goes from start to end-1.
            int rightSum = sumItemsBetween(i + 1, arr.length, arr);
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
