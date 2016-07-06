package com.w_st.codejam;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Round 2 2015 Problem A. Pegman
 */
public class Pegman {

  private List<String> grid;

  public static void main(String[] args) {
    new Pegman().pegman();
  }

  private void pegman() {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        int r = in.nextInt();
        int c = in.nextInt();
        grid = new ArrayList<>(r);
        int[] arrowCountRow = new int[r];
        int[] arrowCountColumn = new int[c];

        in.nextLine();
        for (int j = 0; j < r; j++) {
          String row = in.nextLine();
          int arrow = (int) row.chars().filter(ch -> ch != '.').count();
          arrowCountRow[j] = arrow;
          for (int k = 0; k < row.length(); k++) {
            if (row.charAt(k) != '.') {
              arrowCountColumn[k]++;
            }
          }
          grid.add(row);
        }

        if (IntStream.of(arrowCountRow).sum() == 0) {
          System.out.println("Case #" + i + ": 0");
          continue;
        }

        System.out.println("Case #" + i + ": " + solve(arrowCountRow, arrowCountColumn));
      }
    }
  }

  private String solve(int[] arrowCountRow, int[] arrowCountColumn) {
    int r = arrowCountRow.length;
    int c = arrowCountColumn.length;

    int change = 0;

    for (int y = 0; y < r; y++) {
      for (int x = 0; x < c; x++) {
        if (arrowCountRow[y] == 1 && arrowCountColumn[x] == 1 && grid.get(y).charAt(x) != '.') {
          return "IMPOSSIBLE";
        }
      }
      change += checkRow(c, y);
    }

    for (int x = 0; x < c; x++) {
      change += checkColumn(r, x);
    }

    return Integer.toString(change);
  }

  private int checkColumn(int r, int x) {
    int firstArrow = 0;
    int count = 0;
    for (; firstArrow < r; firstArrow++) {
      char ch = grid.get(firstArrow).charAt(x);
      if (ch != '.') {
        if (ch == '^') {
          count = 1;
        }
        break;
      }
    }

    for (int y = r - 1; firstArrow <= y; y--) {
      char ch = grid.get(y).charAt(x);
      if (ch == 'v') {
        return count + 1;
      } else if (ch != '.') {
        return count;
      }
    }
    return count;
  }

  private int checkRow(int c, int y) {
    int firstArrow = StringUtils.indexOfAnyBut(grid.get(y), '.');
    if (firstArrow == StringUtils.INDEX_NOT_FOUND) {
      return 0;
    }
    int count = (grid.get(y).charAt(firstArrow) == '<') ? 1 : 0;

    for (int x = c - 1; firstArrow <= x; x--) {
      char ch = grid.get(y).charAt(x);
      if (ch == '>') {
        return count + 1;
      } else if (ch != '.') {
        return count;
      }
    }
    return count;
  }
}
