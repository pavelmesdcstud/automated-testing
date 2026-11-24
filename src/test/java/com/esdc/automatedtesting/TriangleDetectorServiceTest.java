package com.esdc.automatedtesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.esdc.automatedtesting.exception.NotATriangleException;
import com.esdc.automatedtesting.model.TriangleType;
import com.esdc.automatedtesting.service.TriangleDetectorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TriangleDetectorServiceTest {

  private final TriangleDetectorService service = new TriangleDetectorService();

  @ParameterizedTest
  @CsvSource({
      "1, 1, 1, ACUTE_ANGLED",
      "3, 4, 5, RIGHT_ANGLED",
      "5, 3, 4, RIGHT_ANGLED",
      "3, 5, 4, RIGHT_ANGLED",
      "3, 4, 4, ACUTE_ANGLED",
      "3, 4, 6, OBTUSE_ANGLED",
      "2, 3, 4, OBTUSE_ANGLED",
      "2147483647, 2147483647, 2147483647, ACUTE_ANGLED",
      "1, 2147483647, 2147483647, ACUTE_ANGLED"
  })
  void classifiesPositiveSides(int a, int b, int c, TriangleType expected) {
    assertEquals(expected, service.detectType(a, b, c));
  }

  @ParameterizedTest
  @CsvSource({
      "1, 1, 7",
      "1, 1, 8",
      "1, 1, 9",
      "1, 1, 10",
      "1, 2, 3",
      "1, 2, 6",
      "1, 2, 7",
      "1, 2, 9",
      "1, 2, 10",
      "1, 3, 4",
      "1, 3, 5",
      "1, 3, 6",
      "1, 3, 7",
      "1, 3, 8",
      "1, 3, 9",
      "1, 3, 10",
      "1, 4, 2147483647",
      "2147483647, 4, 1",
      "1, 2147483647, 1"
  })
  void doesNotAllowNonTriangles(int a, int b, int c) {
    assertThrows(NotATriangleException.class, () -> service.detectType(a, b, c));
  }

  @ParameterizedTest
  @CsvSource({"0, 1, 1", "1, 0, 1", "1, 1, 0", "-1, 1, 1", "1, -1, 1", "1, 1, -1"})
  void rejectsNonPositiveSides(int a, int b, int c) {
    assertThrows(IllegalArgumentException.class, () -> service.detectType(a, b, c));
  }
}
