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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode currNode = head;
        while (currNode != null) {
            length++;
            currNode = currNode.next;
        }
        if (length == 1) {
            return null;
        }
        if (length == n) {
            return head.next;
        }

        currNode = head;
        for (int i = 0; i < length - n - 1; i++) {
            currNode = currNode.next;
        }

        ListNode left = currNode;
        ListNode right = currNode.next.next;
        left.next = right;

        return head;
    }
}
