package com.esdc.automatedtesting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MainTest {

  @ParameterizedTest
  @CsvSource({"'3 4 5', RIGHT_ANGLED",
      "'1 1 1', ACUTE_ANGLED",
      "'3 4 6', OBTUSE_ANGLED",
      "'0 1 1', Invalid",
      "'x 1 1', Invalid",
      "'1 2', Invalid",
      "'2147483648 1 1', Invalid",
      "'1.5 2 2', Invalid"})
  void readsAndReportsInput(String input, String expected) {
    var originalIn = System.in;
    var originalOut = System.out;
    try (var outputByteStream = new ByteArrayOutputStream();
        var inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        var outputPrintStream = new PrintStream(outputByteStream, true, StandardCharsets.UTF_8)
    ) {
      System.setIn(inputStream);
      System.setOut(outputPrintStream);
      Main.main(new String[0]);
      assertTrue(outputByteStream.toString(StandardCharsets.UTF_8).contains(expected));
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      System.setIn(originalIn);
      System.setOut(originalOut);
    }
  }
}
