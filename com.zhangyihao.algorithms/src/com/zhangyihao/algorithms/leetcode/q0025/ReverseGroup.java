package com.zhangyihao.algorithms.leetcode.q0025;

/**
 * K 个一组翻转链表
 *
 * @author zhangyihao
 * @date 2021/11/17
 */
public class ReverseGroup {

    public static void main(String[] args) {
        ListNode head = ReverseGroupOfRecursion.buildList(10);
        ReverseGroup t = new ReverseGroup();
        System.out.println(ReverseGroupOfRecursion.printListNode(t.reverseGroup(head, 2)));
    }

    /**
     * 递归解法
     * @param head 分组头节点
     * @param k 分组元素个数
     * @return 头节点
     */
    public ListNode reverseGroup(ListNode head, int k) {
        // 构造一个临时节点，指向链表头指针，初始化时作为第一次循环的上一分组的尾指针
        ListNode hair = new ListNode(0);
        hair.next = head;

        // 上一分组的尾指针，初始化为指向链表头指针的临时节点
        ListNode prevGroupTail = hair;
        //当前分组的头指针，初始化为链表的头指针
        ListNode groupHead = head;
        //当前分组的尾指针
        ListNode groupTail;
        //下一分组的头指针
        ListNode nextGroupHead;
        int i;
        while (groupHead != null) {
            // 找到当前分组的尾指针
            groupTail = groupHead;
            for (i = 1; i < k && groupTail != null; i++){
                groupTail = groupTail.next;
            }
            // 最后元素为空，说明该分组不够 k 个元素，结束循环
            if (groupTail == null) {
                return hair.next;
            }
            // 记录下个分组的头指针
            nextGroupHead = groupTail.next;
            // 翻转当前分组
            this.reverse(groupHead, groupTail);
            // 将当前分组的头尾重新连接到链表上
            groupHead.next = nextGroupHead;
            prevGroupTail.next = groupTail;
            // 翻转完当前分组后，赋值上一分组尾指针，为下个分组翻转做准备
            prevGroupTail = groupHead;
            groupHead = nextGroupHead;
        }

        return hair.next;
    }

    /**
     * 翻转链表
     * @param head 开始节点
     * @param tail 结束节点
     */
    private void reverse(ListNode head, ListNode tail) {
        ListNode temp = null;
        ListNode prev = head;
        ListNode next = head.next;
        while (prev != tail) {
            prev.next = temp;
            temp = prev;
            prev = next;
            next = next.next;
        }
        tail.next = temp;
    }

}
