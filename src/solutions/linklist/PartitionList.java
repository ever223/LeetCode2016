package solutions.linklist;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-06-01 23:32.
 * @DESCRIPTION:
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = null;
        ListNode greaterHead = null;
        ListNode less = null;
        ListNode greater = null;
        ListNode cursor = head;

        while(cursor != null) {
            if (cursor.val < x) {
                if (lessHead == null) {
                    lessHead = cursor;
                    less = lessHead;
                } else {
                    less.next = cursor;
                    less = less.next;
                }
            } else {
                if (greaterHead == null) {
                    greaterHead = cursor;
                    greater = greaterHead;
                } else {
                    greater.next = cursor;
                    greater = greater.next;
                }
            }
            cursor = cursor.next;
        }
        if(greater != null) {
            greater.next = null;
        }
        if (less != null) {
            less.next = greaterHead;
            return lessHead;
        } else {
            return greaterHead;
        }
    }
}
