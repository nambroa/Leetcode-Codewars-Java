package LeetCode;

import LeetCode.helpers.TreeNode;

/*
235. Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Lowest in this context means CLOSEST node, not lowest in number value!


Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [2,1], p = 2, q = 1
Output: 2


Constraints:
The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.
 */


/*
We need to iterate through the tree. If both p and q are smaller than the current node, it means that, since the tree
is a BST, they are both to the left, and we will find a better LCA there. So we move to the left.

If both p and q are BIGGER than the current node, it means that both are to the right and we can find a closer node to
them there. At the worst case one of p or q would be a better LCA candidate.

If p is smaller and q bigger or viceversa, we are in the most direct descendant possible, thus we return it.
The same is applied if the current is p or q and the other one is its direct descendant. There is no other possible
lowest node.

Total complexity is O(N) with N being the number of nodes in the tree. Space complexity is constant since we don't use
any additional datastructures.
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;

        while (cur != null) {
            if (p.val > cur.val && q.val > cur.val) {
                cur = cur.right;
            } else if (p.val < cur.val && q.val < cur.val) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return cur; // Empty tree edge case.
    }
}
