package solutions.linklist;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-04 20:56.
 * @DESCRIPTION:
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode mNode = dummy;
        ListNode cursor = dummy;
        for(int i = 0; i < n; i ++) {
            if (i == m - 1) {
                mNode = cursor;
            }
            cursor = cursor.next;
        }
        ListNode nNode = cursor;
        ListNode reverse = mNode.next;
        mNode.next = nNode.next;
        nNode.next = null;
        while(reverse != null) {
            ListNode temp = reverse.next;
            reverse.next = mNode.next;
            mNode.next = reverse;
            reverse = temp;
        }
        return dummy.next;
    }
}
