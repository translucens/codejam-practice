package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class FileFixIt {
  /**
   * Round 1B 2010 Problem A. File Fix-it
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCaseCount = in.nextInt();
    for (int i = 1; i <= testCaseCount; ++i) {
      System.out.println("Case #" + i + ": " + solve(in));
    }
  }

  private static int solve(Scanner in) {
    int existedDirCount = in.nextInt();
    int createDirCount = in.nextInt();

    Set<String> dirs = new HashSet<>();
    dirs.add(""); // root
    for (int i = 0; i < existedDirCount; i++) {
      dirs.add(in.next());
    }

    List<String> paths = new ArrayList<>(createDirCount);
    for (int i = 0; i < createDirCount; i++) {
      paths.add(in.next());
    }

    return paths.stream().mapToInt(path -> {
      int mkdir = 0;
      while (!dirs.contains(path)) {
        dirs.add(path);
        path = StringUtils.substringBeforeLast(path, "/");
        ++mkdir;
      }
      return mkdir;
    }).sum();
  }
}
