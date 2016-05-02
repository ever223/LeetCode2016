package solutions.linklist;

import java.time.temporal.Temporal;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-04-30 22:03.
 * @DESCRIPTION:
 */
public class MergeKSortedLists {
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int min = 0;
        ListNode minNode = null;
        while(true) {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minNode == null || (minNode.val > lists[i].val)) {
                    minNode = lists[i];
                    min = i;
                } else if((minNode.val == lists[i].val)) {
                        while (lists[i] != null && lists[i].val == minNode.val) {
                            ListNode temp = lists[i];
                            lists[i] = lists[i].next;
                            temp.next = minNode.next;
                            minNode.next = temp;
                        }
                }
            }
            if (minNode == null) {
                break;
            }
            while (minNode.next != null && minNode.val == minNode.next.val) {
                cur.next = minNode;
                cur = cur.next;
                minNode = minNode.next;
            }
            cur.next = minNode;
            cur = cur.next;
            minNode = minNode.next;
            lists[min] = minNode.next;
            minNode = null;
        }
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(0, lists.length - 1, lists);
    }
    public ListNode mergeKLists(int start, int end, ListNode[] lists) {
        if (end < start) {
            return null;
        } else if(end == start) {
            return lists[start];
        } else {
            ListNode left = mergeKLists(start, (start + end) / 2, lists);
            ListNode right = mergeKLists((start + end) / 2 + 1, end, lists);
            return mergeTwoLists(left, right);
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }
}
