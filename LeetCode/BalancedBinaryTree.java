package LeetCode;

import LeetCode.helpers.TreeNode;

/*
110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

Height-Balanced
A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node
never differs by more than one.

.
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true


Constraints:
The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
 */

/*
We need to find a way to calculate all the subtree heights for every node and then do some abs calculation between pairs

DFS is a good way to iterate through the tree and explore its height. We start at the root and then call DFS with
root.left and root.right and add 1 to a counter. When we get to a leaf, we return that counter, meaning the height
of that subtree is done.

After both subtrees of the current node are done, we do an abs calculation between the two
using subtraction. If it's result is more than 1, we return false. In the end, we return true.

Total time complexity is O(N) with N being the number of nodes in the tree and space complexity is the same since we
are not going to use any additional data structures but we do have a recursive stack that is called each time a new
node is explored.
 */

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        try {
            isBalancedRecu(root, 0);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    private int isBalancedRecu(TreeNode root, int height) {
        if (root == null) {
            return height - 1;
        }

        int leftSubTreeHeight = isBalancedRecu(root.left, height + 1);
        int rightSubTreeHeight = isBalancedRecu(root.right, height + 1);

        if (Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) {
            throw new RuntimeException("Tree not balanced");
        }
        return Math.max(leftSubTreeHeight, rightSubTreeHeight);
    }
}
