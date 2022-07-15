import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    public ListNode linkList(List<Integer> values, int index) {
        if (index == values.size())
            return null;

        ListNode head = new ListNode(values.get(index));
        head.next = linkList(values, index + 1);

        return head;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> values = new ArrayList<Integer>();

        while (list1 != null) {
            values.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            values.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(values);

        return linkList(values, 0);
    }
}