package com.zhangyihao.algorithms.leetcode.q0150;

import com.zhangyihao.algorithms.leetcode.q0025.ListNode;

/**
 * ª•
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @author zhangyihao
 * @date 2022/2/23
 */
public class IntersectionList160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }

}


