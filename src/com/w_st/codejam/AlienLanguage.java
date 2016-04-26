package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/***
 * Qualification Round 2009 Problem A. Alien Language
 */
public class AlienLanguage {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      in.nextInt(); // length of word
      int wordCount = in.nextInt();
      int testCaseCount = in.nextInt();

      List<String> words = new ArrayList<>(wordCount);
      for (int i = 0; i < wordCount; i++) {
        words.add(in.next());
      }

      for (int i = 1; i <= testCaseCount; i++) {
        Pattern p = Pattern.compile("^" + in.next().replace('(', '[').replace(')', ']') + "$");
        System.out.println(
            "Case #" + i + ": " + words.stream().filter(word -> p.matcher(word).matches()).count());
        
      }
    }
  }

}
