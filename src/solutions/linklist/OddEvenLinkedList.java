package solutions.linklist;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-06-01 23:08.
 * @DESCRIPTION:
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
