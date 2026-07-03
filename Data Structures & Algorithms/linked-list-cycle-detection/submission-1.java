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
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (slow.next != null) {
            for (int i = 0; i < 2; i++) {
                fast = fast.next;
                if (fast == null) {
                    return false;
                }
                if (fast == slow) {
                    return true;
                }
            }
            slow = slow.next;
        }
        return false;
    }
}
