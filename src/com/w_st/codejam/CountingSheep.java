package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.Scanner;

public class CountingSheep {
  /**
   * Qualification Round 2016 Problem A. Counting Sheep
   */
  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();
      for (int i = 1; i <= testcaseCount; ++i) {
        System.out.println("Case #" + i + ": " + solve(in.next()));
      }
    }
  }

  private static String solve(String n) {
    if ("0".equals(n)) {
      return "INSOMNIA";
    }

    BitSet digit = new BitSet(10);

    long origN = Long.parseLong(n);
    long kn = 0L;
    while (digit.cardinality() != 10) {
      kn += origN;
      
      for(long dividend = kn; dividend != 0; dividend /= 10){
        digit.set((int) (dividend % 10));
      }
    }
    return String.valueOf(kn);
  }
}
