package solutions.linklist;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-04-30 20:48.
 * @DESCRIPTION:
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy;
        while (n != 0) {
            right = right.next;
            n --;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
