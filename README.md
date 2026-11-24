# automated-testing

## Triangle domain tests

The inputs are three positive Java `int` values, separated by whitespace.
For sorted sides x ≤ y ≤ z, a triangle requires x + y > z. Non-positive values are
rejected; positive values that fail the inequality are not a triangle.

| Domain / boundary | Example (a, b, c) | Expected |
|---|---|---|
| Smallest positive sides | 1, 1, 1 | Acute |
| Below angle boundary | 3, 4, 4 | Acute |
| Angle boundary and permutations | 3, 4, 5; 5, 3, 4; 3, 5, 4 | Right |
| Above angle boundary | 3, 4, 6 | Obtuse |
| Just inside triangle boundary | 2, 3, 4 | Obtuse |
| Triangle boundary | 2, 3, 5 | Not a triangle |
| Outside triangle boundary | 2, 3, 6 | Not a triangle |
| Maximum integer sides | 2147483647, 2147483647, 2147483647 | Acute |
| Large sides and minimum side | 1, 2147483647, 2147483647 | Acute |
| Zero or negative in each position | 0, 1, 1; 1, 0, 1; 1, 1, 0; -1, 1, 1; 1, -1, 1; 1, 1, -1 | Invalid |
| Non-integer, missing or out-of-range console input | x 1 1; 1.5 2 2; 1 2; 2147483648 1 1 | Invalid |
