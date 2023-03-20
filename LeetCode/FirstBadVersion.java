package LeetCode;
/*
278. First Bad Version

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version
of your product fails the quality check. Since each version is developed based on the previous version,
all the versions after a bad version are also bad.

You have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether the version is bad or not.
Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example 1:
Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.

Example 2:
Input: n = 1, bad = 1
Output: 1


Constraints:

1 <= bad <= n <= 231 - 1
 */

/*
Binary search. Remember to avoid the overflow bug that happens if n is too big, it can go above what an int can hold.
O(NlogN) time complexity and constant space complexity.
I like the iterative approach to binary better instead of the recursive one.
 */

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int firstBadVersion = n;
        while (left < right) {
            int mid = left + (right - left) / 2; // To avoid overflow.
            if (isBadVersion(mid)) {
                right = mid;
                firstBadVersion = Math.min(firstBadVersion, mid);
            } else {
                left = mid + 1;
            }
        }
        return firstBadVersion;

    }

    private boolean isBadVersion(int middle) {
        return false; // Mock method, original api is on leetcode.
    }
}
