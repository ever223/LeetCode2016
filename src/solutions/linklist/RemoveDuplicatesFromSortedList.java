package solutions.linklist;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-04 10:02.
 * @DESCRIPTION:
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode preNode = head;
        ListNode cur = head.next;
        while (cur != null) {
            while (cur != null && cur.val == preNode.val) {
                cur = cur.next;
            }
            preNode.next = cur;
            preNode = cur;
        }
        return head;
    }
}
