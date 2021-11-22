package com.zhangyihao.algorithms.leetcode.q0001;

/**
 * 21.合并两个有序链表
 *
 */
public class MergeTwoList {

    public static void main(String[] args) {
        MergeTwoList t = new MergeTwoList();
        ListNode head1 = t.buildNode(new int[]{1, 2, 4});
        ListNode head2 = t.buildNode(new int[]{3, 5, 6, 7});
        System.out.println("list 1:" + MergeTwoList.toString(head1));
        System.out.println("list 2:" + MergeTwoList.toString(head2));
        System.out.println("after merge: " + MergeTwoList.toString(t.mergeTwoList(head2, head1)));
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        // 可以不考虑，l1 或 l2 有空的情况，最后会处理
//        if (l1 == null) {
//            return l2;
//        } else if (l2 == null) {
//            return l1;
//        }

        ListNode head = new ListNode(-1);
        ListNode node = head;

        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 != null) {
            node.next = l1;
        }
        if (l2 != null) {
            node.next = l2;
        }
        return head.next;
    }

    public ListNode buildNode(int[] dataArray) {
        ListNode head = null;
        for (int i = dataArray.length - 1; i >= 0; i--) {
            head = new ListNode(dataArray[i], head);
        }
        return head;
    }

    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(", ");
            }
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
