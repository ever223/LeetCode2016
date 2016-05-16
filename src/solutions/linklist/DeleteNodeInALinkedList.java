package solutions.linklist;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-16 20:28.
 * @DESCRIPTION:
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
