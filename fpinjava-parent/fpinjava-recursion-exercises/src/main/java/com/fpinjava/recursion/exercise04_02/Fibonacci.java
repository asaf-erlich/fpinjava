package com.fpinjava.recursion.exercise04_02;

import com.fpinjava.recursion.listing04_03.TailCall;

import java.math.BigInteger;


public class Fibonacci {

  public static BigInteger fib(int x) {
    return fib(x, BigInteger.ONE, BigInteger.ZERO).eval();
  }

  private static TailCall<BigInteger> fib(final int x, final BigInteger fibMinusOne, final BigInteger fibMinusTwo) {
    if (x == 0) return TailCall.ret(fibMinusTwo);
    if (x == 1) return TailCall.ret(fibMinusOne);

    return TailCall.sus(() -> fib(x - 1, fibMinusOne.add(fibMinusTwo), fibMinusOne));
  }
}
