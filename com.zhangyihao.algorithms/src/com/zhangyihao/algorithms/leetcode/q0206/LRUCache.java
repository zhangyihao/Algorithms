package com.zhangyihao.algorithms.leetcode.q0206;

import com.zhangyihao.algorithms.leetcode.q0003.LengthOfStr;

import java.util.HashMap;
import java.util.Map;

/**
 * 146 LRU 缓存机制
 *
 * @author zhangyihao
 * @date 2021/11/18
 */
public class LRUCache {

    private final Map<Integer, Node> dataMap;
    private int capacity;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dataMap = new HashMap<>(capacity);
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        Node node = this.dataMap.get(key);
        if (node == null) {
            return -1;
        } else {
            this.removeNode(node);
            this.insertNode(this.head, node, this.head.next);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = this.dataMap.get(key);
        if (node != null) {
            node.value = value;
            this.removeNode(node);
            this.insertNode(this.head, node, this.head.next);
        } else {
            // 如果容量达到上限，删除末尾节点
            if (this.capacity == this.dataMap.size()) {
                this.dataMap.remove(this.tail.prev.key);
                this.removeNode(this.tail.prev);
            }
            node = new Node(key, value);
            this.insertNode(this.head, node, this.head.next);
            this.dataMap.put(key, node);
        }
        System.out.println("put: ("+ key + "," + value +"）:" + this.toString());
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    private void insertNode(Node before, Node node, Node after) {
        node.prev = before;
        node.next = after;
        before.next = node;
        after.prev = node;
    }


    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node node = this.head.next;
        while (node != this.tail) {
            sb.append("{").append(node.key).append(", ").append(node.value).append("}");
            node = node.next;
            if (node != this.tail) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("get 1=" + cache.get(1) +" :" + cache.toString());
        cache.put(3, 3);
        System.out.println("get 2=" + cache.get(2) +" :" + cache.toString());
        cache.put(4, 4);
        System.out.println("get 1=" + cache.get(1) +" :" + cache.toString());
        System.out.println("get 3=" + cache.get(3) +" :" + cache.toString());
        System.out.println("get 4=" + cache.get(4) +" :" + cache.toString());
    }

}

