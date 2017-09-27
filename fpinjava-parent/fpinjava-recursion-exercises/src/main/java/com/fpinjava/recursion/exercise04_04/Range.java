package com.fpinjava.recursion.exercise04_04;

import com.fpinjava.common.TailCall;

import java.util.*;

import static com.fpinjava.common.CollectionUtilities.append;
import static com.fpinjava.common.CollectionUtilities.list;


public class Range {

  public static List<Integer> range(Integer start, Integer end) {
    return rangeHelper(start, end, list()).eval();
  }

  private static TailCall<List<Integer>> rangeHelper(final Integer start, final Integer end, final List<Integer> list) {
    if (start >= end) return TailCall.ret(list);

    return TailCall.sus(() -> rangeHelper(start + 1, end, append(list, start)));
  }
}
