# Problem 1 Lambda Notes

This version keeps the same arithmetic as the original solution, but moves the
decision and accumulation behavior into lambdas.

## What Changed

- `is_multiple` is a predicate lambda that captures the divisibility rule.
- `std::accumulate` uses a reducing lambda to decide whether each value should
  contribute to the running sum.
- The algorithm is still a full scan from `0` to `999`, so the learning focus is
  lambda syntax and captures rather than a new optimisation.

## Sample Performance

Compiled with `c++ -std=c++20 -O2` and run once from the `cpp/` directory.

| Version | Result | Time |
| --- | ---: | ---: |
| `problem1.cpp` | 233168 | 541 ns |
| `problem1-lambda.cpp` | 233168 | 750 ns |

On this run, the lambda version was about `1.39x` slower than the original loop.
That is a reasonable tradeoff for a practice variant whose goal is clearer
exposure to predicate and reduction lambdas.