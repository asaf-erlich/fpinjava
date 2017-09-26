package com.fpinjava.recursion.exercise04_01;

import java.math.BigInteger;

public class Fibonacci {
  
  public static BigInteger fib(int x) {
    return fib(x, BigInteger.ONE, BigInteger.ZERO);
  }

  private static BigInteger fib(final int x, final BigInteger fibMinusOne, final BigInteger fibMinusTwo) {
    if (x == 0) return fibMinusTwo;
    if (x == 1) return fibMinusOne;

    return fib(x - 1, fibMinusOne.add(fibMinusTwo), fibMinusOne);
  }
}
