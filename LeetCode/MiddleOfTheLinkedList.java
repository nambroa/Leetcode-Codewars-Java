package LeetCode;

/*
876. Middle of the Linked List

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.


Constraints:
The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100
 */

/*
For this algorithm, we can use a double pointer strategy to get the answer in linear time. We'll be using the tortoise
and hare algorithm. The idea is that a first pointer will move at 100% speed, and the second will move every 2 moves
of the first one. That is, the second pointer will move at 50% speed. When the first pointer reaches the end, the
second pointer will have reached the middle. At that point, we just return that element.
 */

import LeetCode.helpers.ListNode;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;

        ListNode tortoise = head, hare = head;
        int counter = 0;
        while (hare != null) {
            hare = hare.next;
            counter++;
            if (counter % 2 == 0) {
                tortoise = tortoise.next;
            }
        }

        return tortoise;
    }
}
