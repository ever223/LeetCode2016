package solutions.linklist;

import solutions.tree.TreeNode;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-28 22:18.
 * @DESCRIPTION:
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode p = head;
        ListNode q = head;
        while (q != null) {
            p = p.next;
            q = q.next;
            if (q == null) {
                break;
            }
            q = q.next;
        }
        ListNode dummy = new ListNode(-1);
        while (p != null) {
            ListNode temp = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = temp;
        }

        ListNode preHalf = head;
        ListNode postHalf = dummy.next;
        while (postHalf != null) {
            if(preHalf.val != postHalf.val) {
                return false;
            }
            preHalf = preHalf.next;
            postHalf = postHalf.next;
        }

        return true;
    }

    public boolean isPalindrome1(ListNode head) {
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
