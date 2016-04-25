package com.w_st.codejam.scalarproduct;

import java.util.Arrays;
import java.util.Scanner;

public class TestCase {

  int[] v1;
  int[] v2;

  public TestCase(Scanner in) {
    int length = in.nextInt();
    v1 = new int[length];
    v2 = new int[length];

    for (int i = 0; i < length; i++) {
      v1[i] = in.nextInt();
    }
    for (int i = 0; i < length; i++) {
      v2[i] = in.nextInt();
    }
  }

  public long minimumProduct() {
    Arrays.sort(v1);
    Arrays.sort(v2);

    long product = 0;
    for (int i = 0; i < v1.length; i++) {
      product += (long) v1[i] * v2[v2.length - i - 1];
    }
    return product;
  }
}
