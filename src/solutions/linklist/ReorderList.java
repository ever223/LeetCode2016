package solutions.linklist;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-06-02 17:21.
 * @DESCRIPTION:
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode left = head;
        ListNode right = head;
        while(right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        right = reverse(left.next);
        left.next = null;
        left = head;
        while (right != null) {
            ListNode tempRight = right.next;
            ListNode tempLeft = left.next;
            right.next = left.next;
            left.next = right;
            left = tempLeft;
            right = tempRight;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while(head != null) {
            ListNode temp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = temp;
        }
        return dummy.next;
    }
}
