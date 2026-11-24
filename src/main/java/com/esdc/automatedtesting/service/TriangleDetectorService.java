package com.esdc.automatedtesting.service;

import com.esdc.automatedtesting.exception.NotATriangleException;
import com.esdc.automatedtesting.model.TriangleType;
import java.util.Arrays;

public class TriangleDetectorService {

  public TriangleType detectType(int a, int b, int c) {
    if (a <= 0 || b <= 0 || c <= 0) {
      throw new IllegalArgumentException("Sides must be positive integers");
    }
    int[] sides = {a, b, c};
    Arrays.sort(sides);
    long x = sides[0], y = sides[1], z = sides[2];
    if (x + y <= z) {
      throw new NotATriangleException(a,b,c);
    }
    long shortSquares = x * x + y * y;
    long longestSquare = z * z;
    if (shortSquares == longestSquare) {
      return TriangleType.RIGHT_ANGLED;
    }
    return shortSquares > longestSquare
        ? TriangleType.ACUTE_ANGLED : TriangleType.OBTUSE_ANGLED;
  }

}
