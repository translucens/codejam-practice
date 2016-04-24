package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Qualification Round Africa 2010 Problem B. Reverse Words
 */
public class ReverseWords {

  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
      int n = Integer.parseInt(reader.readLine());

      for (int i = 0; i < n; i++) {
        String line = reader.readLine();
        String[] words = line.split(" ");

        System.out.print("Case #" + (i + 1) + ": ");
        for (int j = words.length - 1; 0 <= j; j--) {
          System.out.print(words[j]);
          System.out.print(j == 0 ? System.lineSeparator() : " ");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
