package com.w_st.codejam;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Qualification Round 2013 Problem B. Lawnmower
 */
public class Lawnmower {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        int n = in.nextInt();
        int m = in.nextInt();

        Table<Integer, Integer, Integer> a = HashBasedTable.create();

        for (int j = 0; j < n; j++) {
          for (int k = 0; k < m; k++) {
            a.put(j, k, in.nextInt());
          }
        }
        System.out.println("Case #" + i + ": " + solve(a, n, m));
      }
    }
  }

  private static String solve(Table<Integer, Integer, Integer> a, int n, int m) {
    int[] maxInRow = new int[n];
    for (int i = 0; i < n; i++) {
      maxInRow[i] = 0;
      for (int j = 0; j < m; j++) {
        maxInRow[i] = Math.max(maxInRow[i], a.get(i, j));
      }
    }
    
    int[] maxInCol = new int[m];
    for (int i = 0; i < m; i++) {
      maxInCol[i] = 0;
      for (int j = 0; j < n; j++) {
        maxInCol[i] = Math.max(maxInCol[i], a.get(j, i));
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a.get(i, j) != Math.min(maxInRow[i], maxInCol[j])){
          return "NO";
        }
      }      
    }
    return "YES";
  }
}
