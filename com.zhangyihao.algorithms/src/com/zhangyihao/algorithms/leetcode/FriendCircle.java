package com.zhangyihao.algorithms.leetcode;

/**
 * FriendCircle
 *
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature.
 * For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C.
 * And we defined a friend circle is a group of students who are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1,
 * then the ith and jth students are direct friends with each other, otherwise not.
 * And you have to output the total number of friend circles among all the students.
 *
 * Note:
 *  1. N is in range [1,200].
 *  2. M[i][i] = 1 for all students.
 *  3. If M[i][j] = 1, then M[j][i] = 1.
 *
 *  思路：
 *      使用并查集，将具有朋友关系的放到一个集合中去，最后有几个集合就是几个朋友圈
 *
 * @author zhangyihao1
 * @Date 2019/7/4
 *
 */
public class FriendCircle {

    class Node {
        int data;
        Node parent;
        int rank;
    }

    /**
     * 查找根节点
     * @param node
     * @return
     */
    private Node find(Node node) {
        if(node.parent.equals(node)) {
            return node;
        }
        return this.find(node.parent);
    }

    /**
     * 合并另个集合，秩大的做为新的根节点
     * @param node1
     * @param node2
     * @return
     */
    private Node union(Node node1, Node node2) {
        if(node1.rank < node2.rank) {
            node1.parent = node2;
            return node2;
        } else {
            if(node1.rank == node2.rank) {
                node1.rank += 1;
            }
            node2.parent = node1;
            return node1;
        }
    }


    public int findCircleNum(int[][] M) {
        int people = M.length;
        int circleNum = people;
        Node[] nodes = new Node[people];
        Node node;
        //初始化
        for(int i=0; i<people; i++) {
            node = new Node();
            //自己是自己的父节点
            node.parent = node;
            node.rank = 0;
            node.data = i;
            nodes[i] = node;
        }
        Node node1, node2, node1Parent, node2Parent;
        for(int i=0, len = people - 1; i < len; i++) {
            node1 = nodes[i];
            node1Parent = this.find(node1);
            for(int j = i+ 1; j < people; j++) {
                //不是朋友，不用处理
                if(M[i][j] == 0) {
                    continue;
                }
                node2 = nodes[j];
                node2Parent = this.find(node2);
                //如果不是一个集合的，合并集合，此处需要合并另个集合的根节点
                if(!node1Parent.equals(node2Parent)) {
                    node1Parent = this.union(node1Parent, node2Parent);
                    //每合并一次，朋友圈数量减少1
                    circleNum--;
                }
            }
        }
        return circleNum;
    }



}
