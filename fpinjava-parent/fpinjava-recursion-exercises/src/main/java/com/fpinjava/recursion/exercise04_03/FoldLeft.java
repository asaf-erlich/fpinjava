package com.fpinjava.recursion.exercise04_03;

import java.util.List;

import com.fpinjava.common.Function;
import com.fpinjava.common.TailCall;

import static com.fpinjava.common.CollectionUtilities.head;
import static com.fpinjava.common.CollectionUtilities.tail;


public class FoldLeft {

  public static <T, U> U foldLeft(List<T> ts, U identity, Function<U, Function<T, U>> f) {
    return foldLeftHelper(ts, identity, f).eval();
  }

  public static <T, U> TailCall<U> foldLeftHelper(List<T> ts, U identity, Function<U, Function<T, U>> f) {
    if (ts.isEmpty()) return TailCall.ret(identity);

    return TailCall.sus(() -> foldLeftHelper(tail(ts), f.apply(identity).apply(head(ts)), f));
  }
}
