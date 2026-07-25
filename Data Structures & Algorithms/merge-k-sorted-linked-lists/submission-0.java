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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode head;
        ListNode currNode = null;
        
        //Manually do the first one to set up the head node
        int min = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i].val < lists[min].val) {
                min = i;
            }
        }

        head = lists[min];
        currNode = head;
        lists[min] = lists[min].next;

        while (currNode != null) {
            min = -1;
            for (int i = 0; i < lists.length; i++) {
                if ((min == -1 && lists[i] != null) || (lists[i] != null && lists[i].val < lists[min].val)) {
                    min = i;
                }
            }
            if (min == -1) min = 0;
            currNode.next = lists[min];
            currNode = currNode.next;
            if (lists[min] != null) lists[min] = lists[min].next;
        }
        
        return head;
    }
}
