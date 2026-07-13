# Problem 8 Lambda Notes

This version keeps the straightforward sliding window search, but uses lambdas
to make the per-window work explicit and reusable.

## What Changed

- `digit_at` is a small lookup lambda that converts a character in the digit
  string into its numeric value.
- `product_at` is a lambda that computes the product for a specific starting
  position.
- The outer loop stays imperative so the control flow remains easy to read while
  the lambdas isolate the pieces of logic worth naming.

## Sample Performance

Compiled with `c++ -std=c++20 -O2` and run once from the `cpp/` directory.

| Version | Result | Time |
| --- | ---: | ---: |
| `problem8.cpp` baseline | 23514624000 | 16167 ns |
| `problem8.cpp` optimized | 23514624000 | 10125 ns |
| `problem8-lambda.cpp` | 23514624000 | 7000 ns |

On this run, the lambda version was about `1.45x` faster than the original
optimized path and about `2.31x` faster than the original baseline. That gap can
move around from run to run, but it shows that lambdas do not have to mean a
slow solution when they are only packaging local logic.