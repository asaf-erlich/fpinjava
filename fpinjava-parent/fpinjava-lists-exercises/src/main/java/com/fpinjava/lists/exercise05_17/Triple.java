package com.fpinjava.lists.exercise05_17;

import com.fpinjava.lists.exercise05_16.List;

public class Triple {

  public static List<Integer> triple(List<Integer> list) {
    return list.foldLeft(List.list(), acc -> item -> List.concat(acc, List.list(item * 3)));
  }
}
