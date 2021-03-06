package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Round 1A 2014 Problem A. Charging Chaos
 */
public class ChargingChaos {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {

        int n = in.nextInt();
        in.nextInt(); // l

        long[] devices = new long[n];
        for (int j = 0; j < n; j++) {
          devices[j] = in.nextLong(2);
        }

        long[] outlets = new long[n];
        for (int j = 0; j < n; j++) {
          outlets[j] = in.nextLong(2);
        }

        System.out.println("Case #" + i + ": " + solve(devices, outlets));
      }
    }
  }

  private static String solve(long[] devices, long[] outlets) {

    OptionalInt flipCount = Arrays.stream(outlets).map(o -> devices[0] ^ o)
        .filter(p -> matchFlipPattern(p, devices, outlets)).mapToInt(Long::bitCount).min();
    if (!flipCount.isPresent()) {
      return "NOT POSSIBLE";
    }
    return Integer.toString(flipCount.getAsInt());
  }

  private static boolean matchFlipPattern(long pattern, long[] devices, long[] outlets) {
    Set<Long> flipped = new HashSet<>();
    for (long outlet : outlets) {
      flipped.add(outlet ^ pattern);
    }

    return Arrays.stream(devices).allMatch(flipped::contains);
  }
}
