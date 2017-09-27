package com.fpinjava.recursion.exercise04_06;

import java.util.List;

import com.fpinjava.common.Function;

import static com.fpinjava.common.CollectionUtilities.foldRight;
import static com.fpinjava.common.CollectionUtilities.head;
import static com.fpinjava.common.CollectionUtilities.tail;


public class ComposeAll {

  static <T> Function<T, T> composeAll(List<Function<T, T>> list) {
    return foldRight(list, Function.identity(), f -> f2-> f.compose(f2));
  }

  static <T> Function<T, T> composeAllOriginal(List<Function<T, T>> list) {
    return head(list).compose(composeAllOriginal(tail(list)));
  }
}
