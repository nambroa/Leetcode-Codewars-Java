package LeetCode;

/*
542. 01 Matrix

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.


Example 1:
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Example 2:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]


Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
 */

/*
We will iterate through the matrix in 2 passes. First, we will go in the natural direction (right and down).

If the current position we are iterating is a 0, it means that the distance to 0 is 0.
If it's not a 0 we check to the LEFT and UP directions. These are the 2 directions we have already checked, since
we are moving right and down. We get the minimum value of those 2 directions and add 1 to it since this slot is next
to that position (so 1 position extra needs to be added).

We do the same thing while going left and up. If the position is a 0 we put a 0, otherwise we check RIGHT and DOWN.
We get the minimum between these two and the current number stored by the previous iteration to the right and down.

The reason we split the traversal in two is that, while moving right and down, you can only know left and up directions.
You don't know yet what's to your right.

While moving left and up, same principle. You only know right and down, where you come from. However here you also know
the info from the previous iteration. That's why you also consider that while calculating the minimum. By considering
the previous iteration, you are considering then the left, up, right, and down directions, getting the full picture.

This takes time complexity of O(MxN) since we iterate through the whole matrix TWICE.
Space complexity is also O(MxN) since we return a new matrix.
 */

import java.util.Arrays;

public class O1Matrix {
        public int[][] updateMatrix(int[][] mat) {
            int rows = mat.length;
            int cols = mat[0].length;
            int maxDistance = Integer.MAX_VALUE;

            // Create return matrix with max distance in every slot.
            int[][] ans = new int[rows][cols];
            Arrays.stream(ans).forEach(row -> Arrays.fill(row, maxDistance));

            // Iterating to the RIGHT and DOWN.
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == 0) {
                        ans[i][j] = 0;
                    } else {
                        int left = j > 0 ? ans[i][j - 1] : maxDistance; // Out of bounds check.
                        int up = i > 0 ? ans[i - 1][j] : maxDistance;
                        ans[i][j] = Math.min(left, up) + 1;
                    }
                }
            }
            // Iterating to the LEFT and UP.
            for (int i = rows - 1; i >= 0; i--) {
                for (int j = cols - 1; j >= 0; j--) {
                    if (mat[i][j] != 0) { // No need to check == 0 again, already checked all positions for that.
                        int right = j < cols - 1 ? ans[i][j + 1] : maxDistance; // Out of bounds check.
                        int down = i < rows - 1 ? ans[i + 1][j] : maxDistance;
                        ans[i][j] = Math.min(ans[i][j], Math.min(right, down)+ 1);
                    }
                }
            }

            return ans;
        }
}
