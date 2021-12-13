package com.zhangyihao.algorithms.leetcode.q0118;

/**
 * 141 环形链表
 *
 * @author zhangyihao
 * @date 2021/12/13
 */
public class ListHasCycle {

    public static void main(String[] args) {
        int i = 7;
        ListNode tail = new ListNode(i--, null);
        ListNode entry = null;
        ListNode head = tail;
        for (; i > 0; i--) {
            head = new ListNode(i, head);
            if (i == 4) {
                entry = head;
            }
        }
        tail.next = entry;

        System.out.println(new ListHasCycle().hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            // 相遇，则有环
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

}
