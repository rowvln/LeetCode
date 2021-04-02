/*
    Merge Two Sorted Lists:

    Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    // Create a function that takes in two sorted Linked Lists and merge them together
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // If either lists are empty, return the non-empty one. Otherwise, just return the contents of the second LinkedList.
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        // Since the lists are sorted, we can compare the #'s in both lists and set the smaller one as the next node in the LinkedList until we go through either list one or two. Then we return the list.
        else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}