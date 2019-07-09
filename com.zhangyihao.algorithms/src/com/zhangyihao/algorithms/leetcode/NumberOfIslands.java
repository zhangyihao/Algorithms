package com.zhangyihao.algorithms.leetcode;

/**
 * NumberOfIslands
 *
 * @author zhangyihao1
 * @Date 2019/7/8
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int islandCount = 0;

        int row = grid != null ? grid.length : 0;
        if(row > 0) {
            int col = grid[0].length;
            if(col > 0) {
                boolean[][] visited = new boolean[row][col];
                for(int i = 0; i < row; i++) {
                    for(int j = 0; j < col; j++) {
                        if(!visited[i][j] && grid[i][j] == '1') {
                            visited[i][j] = true;
                            dfs(grid, visited, row, col, i, j + 1);
                            dfs(grid, visited, row, col, i + 1, j);
                            islandCount++;
                        }
                    }
                }
            }
        }
        return islandCount;
    }

    private void dfs(char[][] grid, boolean[][] visited, int row, int col, int rowIndex, int colIndex) {
        if (rowIndex <0 || colIndex < 0 || rowIndex >= row || colIndex >= col) {
            return;
        }
        if(!visited[rowIndex][colIndex] && grid[rowIndex][colIndex] == '1') {
            visited[rowIndex][colIndex] = true;
            dfs(grid, visited, row, col, rowIndex-1, colIndex);
            dfs(grid, visited, row, col, rowIndex, colIndex+1);
            dfs(grid, visited, row, col, rowIndex+1, colIndex);
            dfs(grid, visited, row, col, rowIndex, colIndex - 1);
        }
    }
}
