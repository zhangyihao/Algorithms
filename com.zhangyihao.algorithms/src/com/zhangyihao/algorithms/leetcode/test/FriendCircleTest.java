package com.zhangyihao.algorithms.leetcode.test;

import com.zhangyihao.algorithms.leetcode.FriendCircle;
import com.zhangyihao.algorithms.leetcode.FriendCircleDfs;

/**
 * FriendCircleTest
 *
 * @author zhangyihao1
 * @Date 2019/7/6
 */
public class FriendCircleTest {

    public static void main(String[] args) {
        // 数量为2
        int[][] testCase1 = new int[][]{{1,1,0}, {1,1,0}, {0,0,1}};
        // 数量为1
        int[][] testCase2 = new int[][]{{1,1,0}, {1,1,1}, {0,1,1}};
        // 数量为3
        int[][] testCase3 = new int[][]{
                {1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
                {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
                {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
                {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
                {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};


        FriendCircle friendCircle = new FriendCircle();
        System.out.println(friendCircle.findCircleNum(testCase1));
        System.out.println(friendCircle.findCircleNum(testCase2));
        System.out.println(friendCircle.findCircleNum(testCase3));

        FriendCircleDfs friendCircleDfs = new FriendCircleDfs();
        System.out.println(friendCircleDfs.findCircleNum(testCase1));
        System.out.println(friendCircleDfs.findCircleNum(testCase2));
        System.out.println(friendCircleDfs.findCircleNum(testCase3));
    }

}
