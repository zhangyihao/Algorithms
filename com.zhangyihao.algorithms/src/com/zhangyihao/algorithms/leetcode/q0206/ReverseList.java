package com.zhangyihao.algorithms.leetcode.q0206;

import com.zhangyihao.algorithms.leetcode.q0025.ListNode;
import com.zhangyihao.algorithms.leetcode.q0025.ReverseGroup;
import com.zhangyihao.algorithms.leetcode.q0025.ReverseGroupOfRecursion;

/**
 * 206 翻转单向链表
 *
 * @author zhangyihao
 * @date 2021/11/17
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode head = ReverseGroupOfRecursion.buildList(3);
        ReverseList t = new ReverseList();
        System.out.println(ReverseGroupOfRecursion.printListNode(t.reverseList(head)));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}