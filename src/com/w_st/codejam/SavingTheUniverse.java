package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Qualification Round 2008 Problem A. Saving the Universe
 */
public class SavingTheUniverse {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        int s = in.nextInt();
        String[] engines = new String[s];
        in.nextLine();
        for (int j = 0; j < s; j++) {
          engines[j] = in.nextLine();
        }

        int q = in.nextInt();
        String[] queries = new String[q];
        in.nextLine();
        for (int j = 0; j < q; j++) {
          queries[j] = in.nextLine();
        }

        System.out.println("Case #" + i + ": " + solve(engines, queries));
      }
    }
  }

  private static int solve(String[] engines, String[] queries) {
    int change = 0;

    Set<String> availableEngines = new HashSet<>();
    Collections.addAll(availableEngines, engines);
    for (String q : queries) {
      availableEngines.remove(q);
      if (availableEngines.isEmpty()) {
        Collections.addAll(availableEngines, engines);
        availableEngines.remove(q);
        change++;
      }
    }
    return change;
  }
}
