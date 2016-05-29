package com.w_st.codejam;

import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Round 1B 2013 Problem A. Osmos
 */
public class Osmos {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        long a = in.nextLong();
        int n = in.nextInt();
        SortedMultiset<Long> motes = TreeMultiset.create();
        for (int j = 0; j < n; j++) {
          motes.add(in.nextLong());
        }
        System.out.println("Case #" + i + ": " + solve(a, motes));
      }
    }
  }

  private static int solve(long a, SortedMultiset<Long> motes) {
    if (a == 1) {
      return motes.size();
    }

    int count = 0;
    while (!motes.isEmpty()) {
      Long smallest = motes.firstEntry().getElement();
      if (smallest < a) {
        motes.remove(smallest);
        a += smallest;
        continue;
      }
      int motesCount = motes.size();
      motes.add(a - 1);
      count += Math.min(1 + solve(a, motes), motesCount);
    }
    return count;
  }
}
