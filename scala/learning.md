# Scala Euler Learnings

This file tracks how each Scala solution is approached using a consistent pattern:
- Baseline: first correct implementation.
- Optimize: improved implementation after profiling or reasoning.

Do not record final numeric Euler answers here.

## Problem 1
- Baseline: iterate through the range and filter multiples of 3 or 5.
- Optimize: use arithmetic series sums with inclusion-exclusion to remove iteration.

## Problem 2
- Baseline: generate Fibonacci terms and sum even values under the limit.
- Optimize: generate only even Fibonacci terms using recurrence to reduce checks.

## Problem 3
- Baseline: test each divisor and keep prime factors.
- Optimize: repeatedly divide out factors while shrinking the target value.

## Problem 4
- Baseline: brute force all 3-digit pairs and keep max palindromic product.
- Optimize: iterate downward with early breaks and divisibility pruning.

## Problem 5
- Baseline: fold range with LCM/GCD.
- Optimize: build value from prime powers up to the bound.

## Problem 6
- Baseline: compute sum and sum-of-squares with loops.
- Optimize: use closed-form formulas for constant-time arithmetic.

## Problem 7
- Baseline: increment candidates and test primality by trial division.
- Optimize: use a sieve with an upper bound estimate for nth prime.

## Problem 8
- Baseline: compute product for every fixed-size window from scratch.
- Optimize: rolling window product with zero tracking.

## Problem 9
- Baseline: nested loops over candidate triples.
- Optimize: reduce to fewer variables using algebraic constraints.

## Problem 10
- Baseline: primality test each number then sum primes.
- Optimize: sieve and accumulate prime flags.

## Problem 11
- Baseline: check each cell across all directions with bounds checks.
- Optimize: directional loops specialized for the fixed grid dimensions.

## Problem 12
- Baseline: generate triangle numbers and count divisors by scanning.
- Optimize: factorization-based divisor count using n(n+1)/2 decomposition.

## Problem 13
- Baseline: parse full values and do exact big integer sum.
- Optimize: sum only leading digits when enough for the requested prefix.

## Problem 14
- Baseline: compute each Collatz chain length independently.
- Optimize: memoize known chain lengths to avoid repeated work.

## Problem 15
- Baseline: dynamic programming over grid paths.
- Optimize: direct binomial coefficient computation.

## Problem 16
- Baseline: use built-in big integer power and digit sum.
- Optimize: custom chunked big integer representation for fewer operations.

## Problem 17
- Baseline: build words for each number and count letters.
- Optimize: count letter totals with arithmetic composition rules.

## Problem 18
- Baseline: recursive exploration of both child paths.
- Optimize: bottom-up dynamic programming on the triangle.

## Problem 19
- Baseline: month-by-month weekday simulation.
- Optimize: direct weekday calculation for first-of-month dates.

## Problem 20
- Baseline: factorial with built-in big integer then digit sum.
- Optimize: chunked multiplication representation for less carry overhead.

## Problem 21
- Baseline: compute proper-divisor sums on demand per number.
- Optimize: precompute divisor sums with a sieve-like pass.

## Problem 22
- Baseline: parse, sort, and score names directly.
- Optimize: precompute character scores and reduce repeated conversion.

## Problem 23
- Baseline: compute proper-divisor sums naively and test all abundant pairs.
- Optimize: divisor-sum sieve plus bounded pair generation with early exits.

## Notes For Next Problems
- Keep each section to two bullets: Baseline and Optimize.
- Add measured timing notes only if needed, and avoid recording final Euler answers.
- Prefer algorithmic wins before micro-optimizations.