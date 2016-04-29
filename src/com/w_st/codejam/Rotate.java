package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EnumSet;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

/**
 * Round 1A 2010 Problem A. Rotate
 * */
public class Rotate {

  enum Winner {
    RED, BLUE;
  }

  private String[] board;
  private int n;
  private int k;

  public Rotate(String[] board, int k) {
    this.board = board;
    n = board.length;
    this.k = k;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))){
      int t = in.nextInt();
      for (int i = 1; i <= t; ++i) {
        int n = in.nextInt();
        int k = in.nextInt();

        String[] board = new String[n];
        for (int j = 0; j < n; j++) {
          board[j] = in.next();
        }
        System.out.println("Case #" + i + ": " + new Rotate(board, k).solve());
      }
    }
  }

  private String solve() {
    for (int i = 0; i < n; i++) {
      board[i] = StringUtils.leftPad(StringUtils.remove(board[i], '.'), n, '.');
    }

    EnumSet<Winner> winner = EnumSet.noneOf(Winner.class);
    for (int y = 0; y < n; y++) {
      // horizontal
      if (board[y].contains(StringUtils.repeat('B', k))) {
        winner.add(Winner.BLUE);
      }
      if (board[y].contains(StringUtils.repeat('R', k))) {
        winner.add(Winner.RED);
      }
    }

    // vertical
    for (int x = 0; x < n; x++) {
      find(x, 0, 0, winner);
    }

    // slanting
    for (int y = 0; y <= n - k; y++) {
      find(0, y, 1, winner);
    }
    for (int x = 1; x <= n - k; x++) {
      find(x, 0, 1, winner);
    }
    for (int x = k - 1; x < n; x++) {
      find(x, 0, -1, winner);
    }
    for (int y = 1; y <= n - k; y++) {
      find(n - 1, y, -1, winner);
    }

    if (winner.contains(Winner.RED)) {
      return winner.contains(Winner.BLUE) ? "Both" : "Red";
    }
    return winner.contains(Winner.BLUE) ? "Blue" : "Neither";
  }

  private void find(int startX, int startY, int dRight, EnumSet<Winner> winner) {
    int b = 0;
    int r = 0;
    for (int y = startY; y < n; y++) {
      int x = startX + dRight * (y - startY);
      if (winner.size() == 2 || x < 0 || n <= x) {
        return;
      }

      switch (board[y].charAt(x)) {
        case 'R':
          ++r;
          b = 0;
          if (r == k) {
            winner.add(Winner.RED);
          }
          break;
        case 'B':
          ++b;
          r = 0;
          if (b == k) {
            winner.add(Winner.BLUE);
          }
          break;
        default:
          b = 0;
          r = 0;
          break;
      }
    }
  }
}
