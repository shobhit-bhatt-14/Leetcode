/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode ins = null;

        while (true) {
            if (fast == null || fast.next == null)
                return null;

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ins = slow;
                break;
            }
        }

        ListNode start = head;
        while (start != ins) {
            start = start.next;
            ins = ins.next;
        }

        return ins;
    }
}