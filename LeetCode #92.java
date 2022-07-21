/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head.next == null)
            return head;

        ListNode temp = new ListNode();
        temp.next = head;

        ListNode prev = temp;
        ListNode current = head;

        for (int i = 1; i < left; i++) {
            prev = current;
            current = current.next;
        }

        ListNode post = new ListNode();
        while (left < right) {
            post = current.next;
            current.next = post.next;
            post.next = prev.next;
            prev.next = post;

            left++;
        }

        return temp.next;
    }
}