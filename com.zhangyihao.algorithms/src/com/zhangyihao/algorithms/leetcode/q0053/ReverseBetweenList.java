package com.zhangyihao.algorithms.leetcode.q0053;

import com.zhangyihao.algorithms.leetcode.q0025.ListNode;
import com.zhangyihao.algorithms.leetcode.q0025.ReverseGroupOfRecursion;

/**
 * 92. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表
 *
 * @author zhangyihao
 * @date 2022/2/21
 */
public class ReverseBetweenList {

    public static void main(String[] args) {
        ListNode head = ReverseGroupOfRecursion.buildList(5);
        ReverseBetweenList t = new ReverseBetweenList();
        head = t.reverseBetween(head, 1, 5);
        System.out.println(ReverseGroupOfRecursion.printListNode(head));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 1 -> 2 -> 3 -> 4 -> 5
        // 1 -> 4 -> 3 -> 2 -> 5

        // pre -> curr -> next

        ListNode vNode = new ListNode(-1, head);
        ListNode startHead = vNode;
        ListNode curr = vNode;
        int index = 0;
        while(index < left && curr != null) {
            index++;
            startHead = curr;
            curr = curr.next;
        }
        if (curr == null) {
            return vNode.next;
        }

        ListNode next = curr.next;
        while (next != null && index < right) {
            curr.next = next.next;
            next.next = startHead.next;
            startHead.next = next;
            next = curr.next;
            index++;
        }

        return vNode.next;
    }

}
