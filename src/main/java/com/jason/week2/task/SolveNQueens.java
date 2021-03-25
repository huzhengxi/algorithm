package com.jason.week2.task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N 皇后
 */
public class SolveNQueens {

  public List<List<String>> solveNQueens(int n) {
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '.';
      }
    }
    List<List<String>> res = new ArrayList<List<String>>();
    dfs(board, 0, res);
    return res;
  }

  private void dfs(char[][] board, int colIndex, List<List<String>> res) {
    if (colIndex == board.length) {
      res.add(construct(board));
      return;
    }

    for (int i = 0; i < board.length; i++) {
      if (invalid(board, i, colIndex)) {
        board[i][colIndex] = 'Q';
        dfs(board, colIndex + 1, res);
        board[i][colIndex] = '.';
      }
    }

  }

  private boolean invalid(char[][] board, int x, int y) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < y; j++) {
        if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i)) {
          return false;
        }
      }
    }
    return true;
  }

  private List<String> construct(char[][] board) {
    List<String> res = new LinkedList<String>();
    for (int i = 0; i < board.length; i++) {
      String s = new String(board[i]);
      res.add(s);
    }
    return res;
  }

}
