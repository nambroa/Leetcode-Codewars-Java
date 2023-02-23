package LeetCode;

import LeetCode.helpers.ListNode;

/*
21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 */

/*

 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Check if one list is null, then return the other.
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        // Get head of merged list, knowing that no list is empty.
        ListNode head = null;
        ListNode temp = null;
        ListNode l3 = null;
        if (list1.val < list2.val) {
            head = list1;
            l3 = list1;
            temp = list1.next;
            list1.next = list2;

            list1 = temp;
        } else {
            head = list2;
            l3 = list2;
            temp = list2.next;
            list2.next = list1;

            list2 = temp;
        }

        // Make the rest of the merged list.
        while (list1 != null || list2 != null) {
            // If the end of one list gets reached first, do not compare both, just grab from the other list.
            if (list1 == null) {
                l3.next = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                l3.next = list1;
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                l3.next = list1;
                list1 = list1.next;
            } else {
                l3.next = list2;
                list2 = list2.next;
            }
            l3 = l3.next;
        }

        return head;

    }


}
