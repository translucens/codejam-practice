package com.w_st.codejam;

import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Round 1A 2016 Problem B. Rank and File
 */
public class RankAndFile {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        int n = in.nextInt();
        int lines = 2 * n - 1;

        Multiset<Integer> heights = TreeMultiset.create();
        for (int j = 0; j < lines * n; j++) {
          heights.add(in.nextInt());
        }

        System.out.print("Case #" + i + ":");
        heights.entrySet().stream().filter(h -> h.getCount() % 2 != 0)
            .forEach(h -> System.out.print(" " + h.getElement()));
        System.out.println();
      }
    }
  }
}
