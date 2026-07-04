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
    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }
        int length = 1;
        ListNode currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
            length++;
        }
        
        currNode = head;
        for (int i = 0; i < (length + 1)/2 - 1; i++) {
            currNode = currNode.next;
        }

        ListNode temp = currNode;
        currNode = currNode.next;
        temp.next = null;

        //reverse the direction of the nodes
        ListNode prevNode = null;
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        ListNode l = head;        
        ListNode r = prevNode;
        while (r != null) {
            ListNode lNext = l.next;
            ListNode rNext = r.next;

            l.next = r;
            r.next = lNext;

            l = lNext;
            r = rNext;
        }
    }
}
