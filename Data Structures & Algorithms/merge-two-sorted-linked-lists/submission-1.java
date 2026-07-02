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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;
        ListNode currNode;
        ListNode l1 = list1;
        ListNode l2 = list2;
        if (list1 == null && list2 == null) {
            head = null;
            return head;
        }
        if (list1 == null) {
            head = list2;
            l2 = l2.next; 
        } else if (list2 == null){
            head = list1;
            l1 = l1.next;
        } else if (list1.val < list2.val) {
            head = list1;
            l1 = l1.next;
        } else {
            head = list2;
            l2 = l2.next; 
        }
        currNode = head;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                currNode.next = l2;
                l2 = l2.next;
            }
            else if (l2 == null) {
                currNode.next = l1;
                l1 = l1.next;
            }
            else if (l1.val < l2.val) {
                currNode.next = l1;
                l1 = l1.next;
                
            } else {
                currNode.next = l2;
                l2 = l2.next;
            }
            currNode = currNode.next;
        }

        return head;
    }
}