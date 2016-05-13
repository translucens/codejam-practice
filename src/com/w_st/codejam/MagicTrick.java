package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Qualification Round 2014 Problem A. Magic Trick
 */
public class MagicTrick {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {

        int firstAnswer = in.nextInt();
        Set<Integer> firstRow = new HashSet<>();
        for (int j = 0; j < 16; j++) {
          int card = in.nextInt();

          if (4 * (firstAnswer - 1) <= j && j <= 4 * firstAnswer - 1) {
            firstRow.add(card);
          }
        }
        int secondAnswer = in.nextInt();
        Set<Integer> secondRow = new HashSet<>();
        for (int j = 0; j < 16; j++) {
          int card = in.nextInt();

          if (4 * (secondAnswer - 1) <= j && j <= 4 * secondAnswer - 1) {
            secondRow.add(card);
          }
        }
        System.out.println("Case #" + i + ": " + solve(firstRow, secondRow));
      }
    }
  }

  private static String solve(Set<Integer> firstRow, Set<Integer> secondRow) {
    firstRow.retainAll(secondRow);
    switch (firstRow.size()){
      case 0:
        return "Volunteer cheated!";
      case 1:
        return firstRow.iterator().next().toString();
      default:
        return "Bad magician!";
    }
  }
}
