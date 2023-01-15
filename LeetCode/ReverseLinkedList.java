package LeetCode;

import LeetCode.helpers.ListNode;

/*
206. Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Input: head = [1,2]
Output: [2,1]

Input: head = []
Output: []

Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        // Edge cases: empty list or list of 1 element.
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        /*
         We iterate through the linked list and move the pointers in place
         */
        ListNode curNode = head;
        ListNode prevNode = null;
        while (curNode != null) {
            ListNode tempNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = tempNode;
        }
        return prevNode;
    }
}
