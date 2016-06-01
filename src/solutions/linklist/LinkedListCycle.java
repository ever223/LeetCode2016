package solutions.linklist;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-06-01 22:59.
 * @DESCRIPTION:
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode pre = head;
        ListNode post = head;
        while(pre != null) {
            pre = pre.next;
            post = post.next;
            if (pre != null) {
                pre = pre.next;
            } else {
                return false;
            }
            if (pre == post) {
                return true;
            }
        }
        return false;
    }
}
