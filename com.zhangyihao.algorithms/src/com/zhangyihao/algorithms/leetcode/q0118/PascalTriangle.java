package com.zhangyihao.algorithms.leetcode.q0118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyihao
 * @date 20210311
 */
public class PascalTriangle {

    public static void main(String[] args) {
        PascalTriangle triangle = new PascalTriangle();
        triangle.generate(5).forEach(System.out::println);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangleList = new ArrayList<>(numRows);
        for (int row = 0; row < numRows; row++) {
            int colNum = row + 1;
            List<Integer> rowList = new ArrayList<>(colNum);
            for(int col = 0; col < colNum; col++) {
                if(col == 0 || col == row) {
                    rowList.add(1);
                } else {
                    List<Integer> lastRowList = triangleList.get(row -1);
                    rowList.add(lastRowList.get(col - 1) + lastRowList.get(col));
                }
            }
            triangleList.add(rowList);
        }
        return triangleList;
    }

}
