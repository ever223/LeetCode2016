package solutions.linklist;

import solutions.tree.TreeNode;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-28 22:18.
 * @DESCRIPTION:
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode cursor = head;
        while(cursor != null) {
            length ++;
            cursor = cursor.next;
        }
        if(length < 2) {
            return true;
        }
        cursor = head;
        ListNode dummy = new ListNode(-1);
        for (int i = 0; i < length / 2; i++) {
            ListNode temp = cursor.next;
            cursor.next = dummy.next;
            dummy.next = cursor;
            cursor = temp;
        }
        if (length % 2 == 1) {
            cursor = cursor.next;
        }

        ListNode preHalf = dummy.next;
        ListNode postHalf = cursor;
        for (int i = 0; i < length / 2; i++) {
            if(preHalf.val != postHalf.val) {
                return false;
            }
            preHalf = preHalf.next;
            postHalf = postHalf.next;
        }
        return true;
    }
}
