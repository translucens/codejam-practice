package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Round 1C 2016 Problem A. Senate Evacuation
 */
public class SenateEvacuation {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        int count = in.nextInt(); // parties count
        TreeSet<Integer> parties = new TreeSet<>();
        for (int j = 0; j < count; j++) {
          parties.add(Integer.valueOf(in.nextInt() * 100 + j));
        }
        System.out.println("Case #" + i + ": " + solve(parties));
      }
    }
  }

  private static String solve(TreeSet<Integer> parties) {
    List<Character> plan = new ArrayList<>();

    while (!parties.isEmpty()) {
      int largest = parties.pollLast().intValue();
      plan.add(Character.valueOf((char) ('A' + largest % 100)));
      if (largest >= 200) {
        parties.add(Integer.valueOf(largest - 100));
      }
    }

    StringBuilder sb = new StringBuilder(plan.size() + plan.size() / 2);
    if (plan.size() % 2 == 1) {
      for (int i = 0; i < plan.size() - 4; i += 2) {
        sb.append(plan.get(i)).append(plan.get(i + 1)).append(' ');
      }

      sb.append(plan.get(plan.size() - 3)).append(' ').append(plan.get(plan.size() - 2))
          .append(plan.get(plan.size() - 1));
      return sb.toString();
    }

    sb.append(plan.get(0)).append(plan.get(1));
    for (int i = 2; i < plan.size() - 1; i += 2) {
      sb.append(' ').append(plan.get(i)).append(plan.get(i + 1));
    }
    return sb.toString();
  }
}
