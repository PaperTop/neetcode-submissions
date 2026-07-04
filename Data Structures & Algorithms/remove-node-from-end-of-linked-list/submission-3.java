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
        ListNode dummy = new ListNode(0, head);
        ListNode l = dummy;
        ListNode r = head;

        for (int i = 0; i < n; i++) {
            r = r.next;
        }

        while (r != null) {
            l = l.next;
            r = r.next;
        }

        l.next = l.next.next;
        return dummy.next;
    }
}
