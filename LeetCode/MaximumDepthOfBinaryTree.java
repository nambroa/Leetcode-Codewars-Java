package LeetCode;

/*
104. Maximum Depth of Binary Tree

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path
from the root node down to the farthest leaf node.



Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2


Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
 */

/*
Lol, this is just DFS. Iterate through all the tree nodes with DFS with an added height counter, beginning at 1 for the
root. Each level we go lower, we add 1 to the counter. When we get the depth of the left and right subtree using
this method, we return the max between the two.

Time complexity is linear in relation to the number of TreeNodes so O(N). Same for space complexity since even though
we don't use additional data structures, we do have a recursive stack as big as the number of TreeNodes.
 */

import LeetCode.helpers.TreeNode;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return maxDepthRecu(root, 1);
    }

    private int maxDepthRecu(TreeNode root, int depth) {
        if (root == null) return depth - 1;

        int left_depth = maxDepthRecu(root.left, depth + 1);
        int right_depth = maxDepthRecu(root.right, depth + 1);

        return Math.max(left_depth, right_depth);
    }

}
