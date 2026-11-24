package com.esdc.automatedtesting;

import com.esdc.automatedtesting.exception.NotATriangleException;
import com.esdc.automatedtesting.service.TriangleDetectorService;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter three positive ints separated by whitespace:");
    int[] sides = new int[3];
    for (int i = 0; i < sides.length; i++) {
      if (!scanner.hasNextInt()) {
        System.out.println("Invalid input");
        return;
      }
      sides[i] = scanner.nextInt();
    }
    try {
      System.out.println(new TriangleDetectorService().detectType(sides[0], sides[1], sides[2]));
    } catch (NotATriangleException e) {
      System.out.println(e.getMessage());
    } catch (IllegalArgumentException e) {
      System.out.println("Invalid input: " + e.getMessage());
    }
  }
}
