package solutions.sort;

import solutions.linklist.ListNode;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-06-02 07:52.
 * @DESCRIPTION:
 */

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        while(right != null) {
            right = right.next;
            if (right != null) {
                right = right.next;
                left = left.next;
            }
        }
        right = sortList(left.next);
        left.next = null;
        left = sortList(head);

        return merge(left, right);
    }

    public ListNode merge(ListNode p, ListNode q) {
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        while(p != null && q != null) {
            if (p.val <= q.val) {
                cursor.next = p;
                p = p.next;
            } else {
                cursor.next = q;
                q= q.next;
            }
            cursor = cursor.next;
        }
        cursor.next = (p == null) ? q : p;
        return dummy.next;
    }
}
