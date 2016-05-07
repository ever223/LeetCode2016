package solutions.sort;

import solutions.linklist.ListNode;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-04 18:32.
 * @DESCRIPTION:
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while(head != null) {
            ListNode cursor = dummy;
            // = 保持算法的稳定性
            while(cursor.next != null && cursor.next.val <= head.val) {
                cursor = cursor.next;
            }
            ListNode temp = head.next;
            head.next = cursor.next;
            cursor.next = head;
            head = temp;
        }
        return dummy.next;
    }
}
