package LeetCode;

import LeetCode.helpers.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
543. Diameter of Binary Tree

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:
Input: root = [1,2]
Output: 1
 */

/*
Even though this problem is classified as easy, it uses several tricks found in medium and hard exercises.

The main idea is to understand that the max diameter is NOT the longest path to the left and the longest path to the
right of the tree. That is a common pitfall. You can have the case of a tree with a left subtree with almost nothing
and a right subtree with an inner left to right path that does not pass through the root being the biggest.

With that in mind, we can use DFS to move through the tree. We will have the maxDiameter variable start at 0. We want
to dynamically update this variable so we will store it in a non primitive datastruct.

The idea is now simple. We move to the left and right of the current node. If we reach a leaf, we return 0, since
the diameter of a leaf is 0 (no edges). After getting the diameter to the right and left, we compare the sum of those
against the current maximum, and store the max between those 2 variables. Finally, we return the current height, which
is the max between the right and left diameter (number of edges) plus one since this bubbles up.

Time complexity is thus linear in relation to the number of treenodes so O(N). Space complexity is also linear because
even though we don't use a lot of memory for datastructs, the recursive stack is as big as the number of nodes.
 */

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<Integer> maxDiameter = new ArrayList<>(); // Done as a list so I can update it in another function.
        maxDiameter.add(0);

        getDiameter(root, maxDiameter);

        return maxDiameter.get(0);
    }

    private int getDiameter(TreeNode node, List<Integer> maxDiameter) {
        if (node == null) return 0;

        int leftDiam = getDiameter(node.left, maxDiameter);
        int rightDiam = getDiameter(node.right, maxDiameter);

        int curMaxDiam = maxDiameter.remove(0);
        maxDiameter.add(Math.max(leftDiam + rightDiam, curMaxDiam));

        return Math.max(leftDiam, rightDiam) + 1;
    }


}
