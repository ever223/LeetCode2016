package solutions.linklist;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-01 10:21.
 * @DESCRIPTION:
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = head;
        int i = k;
        while (i != 0 && head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = dummy.next;
            dummy.next = temp;
            i --;
        }
        if (i == 0) {
            tail.next = reverseKGroup(head, k);
        } else {
            ListNode temp = dummy.next;
            dummy.next = null;
            while (temp != null) {
                ListNode node = temp.next;
                temp.next = dummy.next;
                dummy.next = temp;
                temp = node;
            }
        }
        return dummy.next;
    }
}
