package solutions.linklist;

import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-02 19:22.
 * @DESCRIPTION:
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int len = 1;
        ListNode cursor = head;
        while (cursor.next != null) {
            len ++;
            cursor = cursor.next;
        }
        cursor.next = head;
        for (int i = 0; i < len - k / len; i++) {
            cursor = cursor.next;
        }

        head = cursor.next;
        cursor.next = null;
        return head;
    }
}
