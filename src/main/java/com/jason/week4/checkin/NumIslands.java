package com.jason.week4.checkin;

import com.jason.utils.UnionFind;

/**
 * 200. 岛屿数量
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumIslands {

  /**
   * 并查集
   *
   * @param grid
   * @return
   */
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int nr = grid.length, nc = grid[0].length;
    UnionFind unionFind = new UnionFind(grid);
    for (int r = 0; r < nr; ++r) {
      for (int c = 0; c < nc; ++c) {
        if (grid[r][c] == '1') {
          grid[r][c] = '0';
          if (r - 1 >= 0 && grid[r - 1][c] == '1') {
            unionFind.union(r * nc + c, (r - 1) * nc + c);
          }
          if (r + 1 < nr && grid[r + 1][c] == '1') {
            unionFind.union(r * nc + c, (r + 1) * nc + c);
          }
          if (c - 1 >= 0 && grid[r][c - 1] == '1') {
            unionFind.union(r * nc + c, r * nc + c - 1);
          }
          if (c + 1 < nc && grid[r][c + 1] == '1') {
            unionFind.union(r * nc + c, r * nc + c + 1);
          }
        }

      }
    }
    return unionFind.getCount();
  }




  public static void main(String[] args) {
    NumIslands numIslands = new NumIslands();
    char[][] grid = {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    };
    System.out.println(numIslands.numIslands(grid));

    char[][] grid1 = {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'},
    };

    System.out.println(numIslands.numIslands(grid1));

  }
}
