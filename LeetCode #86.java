import java.util.ArrayList;
import java.util.List;

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
    public ListNode partition(ListNode head, int x) {
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();

        while (head != null) {
            int value = head.val;

            if (value < x)
                left.add(value);
            else if (value >= x)
                right.add(value);

            head = head.next;
        }

        left.addAll(right);

        if(left.isEmpty())
            return null;

        ListNode temp = new ListNode(left.get(0));
        head = new ListNode();
        head.next = temp;

        for (int l = 1; l < left.size(); l++) {
            temp.next = new ListNode(left.get(l));
            temp = temp.next;
        }

        return head.next;
    }
}