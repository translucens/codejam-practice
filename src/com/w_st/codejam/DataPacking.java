package com.w_st.codejam;

import com.google.common.collect.BoundType;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Round 2 2014 Problem A. Data Packing
 */
public class DataPacking {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        int n = in.nextInt();
        int x = in.nextInt();
        SortedMultiset<Integer> s = TreeMultiset.create();
        for (int j = 0; j < n; j++) {
          s.add(in.nextInt());
        }
        System.out.println("Case #" + i + ": " + solve(x, s));
      }
    }
  }

  private static int solve(int x, SortedMultiset<Integer> s) {
    int disc = 0;
    while (!s.isEmpty()) {
      disc++;
      Integer higher = s.lastEntry().getElement();
      s.remove(higher);
      SortedMultiset<Integer> pairSet = s.headMultiset(x - higher, BoundType.CLOSED);
      if (!pairSet.isEmpty()) {
        pairSet.remove(pairSet.lastEntry().getElement());
      }
    }
    return disc;
  }
}
