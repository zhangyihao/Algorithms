package com.zhangyihao.algorithms.leetcode.q0025;

import java.util.StringJoiner;

/**
 * K 个一组翻转链表
 * @author zhangyihao
 */
public class ReverseGroupOfRecursion {

    public static void main(String[] args) {
        ListNode head = ReverseGroupOfRecursion.buildList(10);
        ReverseGroupOfRecursion t = new ReverseGroupOfRecursion();
        System.out.println(ReverseGroupOfRecursion.printListNode(t.reverseKGroup(head, 7)));
    }

    public static ListNode buildList(int count) {
        ListNode head = null;
        while (count > 0) {
            head = new ListNode(count, head);
            count--;
        }
        if (head != null) {
            System.out.println(ReverseGroupOfRecursion.printListNode(head));
        }
        return head;
    }

    public static String printListNode(ListNode head) {
        StringJoiner joiner = new StringJoiner(" -> ");
        do {
            joiner.add(String.valueOf(head.val));
            head = head.next;
        } while (head != null);
        return joiner.toString();
    }

    /**
     * 递归解法
     * @param head 分组头节点
     * @param k 分组元素个数
     * @return 头节点
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        // 循环，找到分组的最后元素 groupTail
        ListNode groupTail = head;
        int i = 1;
        while (i < k && groupTail != null){
            groupTail = groupTail.next;
            i++;
        }
        // 最后元素为空，说明该分组不够 k 个元素，直接返回
        if (groupTail == null) {
            return head;
        }
        // 递归调用，翻转下个分组
        ListNode nextGroupHead = this.reverseKGroup(groupTail.next, k);
        // 翻转当前分组
        ListNode prev = head;
        ListNode next = head.next;
        ListNode temp = null;
        while (prev != groupTail) {
           prev.next = temp;
           temp = prev;
           prev = next;
           next = next.next;
        }
        groupTail.next = temp;

        // 将翻转后的尾节点指向下个分组的头节点
        head.next = nextGroupHead;
        // 当前分组的尾节点变为头节点，返回
        return groupTail;
    }

}
