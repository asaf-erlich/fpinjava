package com.fpinjava.lists.exercise05_07;

import com.fpinjava.lists.exercise05_06.List;

public class Sum {

  public static Integer sum(List<Integer> ints) {
    return sum(0, ints);
  }

  private static Integer sum(final int accumulator, final List<Integer> ints) {
    if (ints.isEmpty()) return accumulator;

    return sum(accumulator + ints.head(), ints.tail());
  }
}
