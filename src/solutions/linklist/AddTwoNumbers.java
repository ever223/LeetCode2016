package solutions.linklist;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-04-18 23:02.
 * @DESCRIPTION:
 */


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) {
            l1 = l2;
        }
        while (l1 != null) {
            int sum = carry + l1.val;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }
}
