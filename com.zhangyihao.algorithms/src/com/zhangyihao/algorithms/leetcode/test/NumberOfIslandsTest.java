package com.zhangyihao.algorithms.leetcode.test;

import com.zhangyihao.algorithms.leetcode.NumberOfIslands;

/**
 * NumberOfIslandsTest
 *
 * @author zhangyihao1
 * @Date 2019/7/8
 */
public class NumberOfIslandsTest {

    public static void main(String[] args) {
        NumberOfIslands obj = new NumberOfIslands();
        //1
        char[][] testCase1 = new char[][]{{'1','1','1','1','0'},{'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        //3
        char[][] testCase2 = new char[][]{{'1','1','0','0','0'},{'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        //1
        char[][] testCase3 = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};


        System.out.println(obj.numIslands(testCase1));
        System.out.println(obj.numIslands(testCase2));
        System.out.println(obj.numIslands(testCase3));
        System.out.println(obj.numIslands(null));
        System.out.println(obj.numIslands(new char[][]{}));
    }

}
