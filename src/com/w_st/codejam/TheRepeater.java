package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Round 1B 2014 The Repeater
 */
public class TheRepeater {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        int n = in.nextInt();
        String[] strings = new String[n];
        for (int j = 0; j < n; j++) {
          strings[j] = in.next();
        }
        System.out.println("Case #" + i + ": " + solve(strings));
      }
    }
  }

  private static String solve(String[] strings) {
    String first = strings[0];
    List<Character> chars = new ArrayList<>();

    char c0 = '*';
    for (char c : first.toCharArray()) {
      if (c0 != c) {
        chars.add(c);
        c0 = c;
      }
    }

    int[][] counts = new int[strings.length][];
    for (int i = 0; i < strings.length; i++) {
      counts[i] = count(strings[i], chars);

      if (counts[i] == null) {
        return "Fegla Won";
      }
    }

    int sum = 0;
    for (int c = 0; c < chars.size(); c++) {

      int min = Integer.MAX_VALUE;
      for (int i = 0; i < strings.length; i++) {
        int sumij = 0;
        for (int j = 0; j < strings.length; j++) {
          sumij += Math.abs(counts[i][c] - counts[j][c]);
        }
        min = Math.min(min, sumij);
      }
      sum += min;
    }
    return Integer.toString(sum);
  }

  private static int[] count(String string, List<Character> chars) {
    int[] result = new int[chars.size()];
    int index = 0;
    for (char c : string.toCharArray()) {
      if (c != chars.get(index)) {
        if (result[index] == 0 || index + 1 == chars.size() || chars.get(index + 1) != c) {
          return null;
        }
        ++index;
      }
      ++result[index];
    }
    return index + 1 == chars.size() ? result : null;
  }
}
