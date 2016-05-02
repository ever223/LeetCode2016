package solutions.linklist;

import java.util.Currency;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-04-30 23:25.
 * @DESCRIPTION:
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (head != null && head.next != null) {
            ListNode temp = head;

            cur.next = head.next;
            cur = cur.next;

            head = head.next.next;

            cur.next = temp;
            cur = cur.next;
        }
        cur.next = head;
        return dummy.next;
    }
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = head.next.next;
        ListNode second = head.next;
        second.next = head;
        head.next = swapPairs(node);
        return second;
    }
}
