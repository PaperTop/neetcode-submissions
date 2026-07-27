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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ListNode res = new ListNode(0);
        ListNode start = res;

        ListNode first = head;
        ListNode prev;
        ListNode curr = res;
        ListNode next = head;

        while (next != null) {
            ListNode scout = next;
            for (int i = 0; i < k; i++) {
                if (scout == null) {
                    return res.next;
                }
                scout = scout.next;
            }

            //set the first one to point to the beginning of the next group
            for (int i = 0; i < k; i++) {
                prev = curr;
                curr = next;
                next = next.next;
                curr.next = prev;
            }

            start.next = curr;
            first.next = next;
            start = first;
            first = next;
        }
        return res.next; 
    }
}
