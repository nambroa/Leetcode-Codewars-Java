package LeetCode;

import LeetCode.helpers.ListNode;

import java.util.IdentityHashMap;

/*
141. Linked List Cycle

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.


Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.


Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 */

/*
A pretty good trick for this exercise is to memoize already traversed list nodes. For example a set.

If the list has a cycle, we will at some point see a node twice, and the set will notify us that it's a duplicate.
If the list doesn't have a cycle, we will iterate through the whole list and finish. At that point we return true.

IdentityHashMap uses == instead of equals(), which means that two list nodes with the same value and next will STILL
be different, which is exactly what we want.

The time complexity for this algorithm is O(N) with N being the number of nodes in the linked list.
Space complexity is the same because the set can have at most all the elements of the linked list.
 */

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        IdentityHashMap<ListNode, ListNode> visited = new IdentityHashMap<>();
        while (head != null) {
            if (visited.containsKey(head)){
                return false;
            }
            else{
                visited.put(head, head);
            }
            head = head.next;
        }
        return true;
    }

}
