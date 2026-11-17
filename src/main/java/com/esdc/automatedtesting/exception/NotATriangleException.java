package com.esdc.automatedtesting.exception;

public class NotATriangleException extends RuntimeException {

  public NotATriangleException(int a, int b, int c) {
    super("The triangle with sides (%d, %d, %d) cannot exist".formatted(a, b, c));
  }
}
