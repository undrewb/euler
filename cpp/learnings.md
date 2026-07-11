# Euler Learnings

## Problem 1
- Goal: sum multiples of 3 or 5 below 1000.
- Approach: single pass from 0 to 999 with modulo checks.
- Learning: simple O(n) scan is clear and fast for small bounds.
- Telemetry: evaluate() timing is measured with steady_clock in nanoseconds.

## Problem 2
- Goal: sum even Fibonacci terms not exceeding 4,000,000.
- Approach: iterative Fibonacci generation using two rolling values (a, b).
- Learning: a rolling two-variable Fibonacci loop is simple and efficient for this bound.
- Telemetry: evaluate() timing is measured with steady_clock in nanoseconds.

## Problem 3
- Goal: largest prime factor of 600851475143.
- Fast approach: repeated factorization (strip 2s, then test odd divisors while dividing n down).
- Comparison approach: divisor scan plus is_prime checks.
- Learning: algorithm choice matters more than micro-optimizing helper functions.
- Performance note: direct factorization measured 1000 ns vs 482833 ns using is_prime (about 482.833x slower with is_prime in that run).

## Problem 4
- Goal: largest palindrome made from the product of two 3-digit numbers.
- Baseline approach tried: brute-force all pairs and check whether each product is a palindrome.
- Optimizations tried:
	- iterate from large factors downward
	- break early when current products cannot beat the current best
	- use the 11-divisibility property for 6-digit palindromes to skip many pairs
- Measured observation: baseline 802000 ns vs optimized 8708 ns in one run (about 92.10x speedup).
- Learning: pruning and math properties can dominate micro-level code tweaks for search problems.

## Problem 5
- Goal: smallest positive number evenly divisible by all numbers from 1 to 20.
- Approach tried: iterative LCM fold from 1 through 20 using Euclid's GCD.
- Optimization tried: prime-power construction for primes up to 20.
- Measured observation: first optimized attempt (sieve-based prime-power) was slower than LCM fold in one run; low-overhead prime-power with fixed primes measured 500 ns (baseline) vs 125 ns (optimized), about 4.0x speedup in a later run.
- Learning: for tiny fixed bounds, reducing overhead (allocation/extra loops) matters more than asymptotic elegance.

## Problem 6
- Goal: difference between the square of the sum and the sum of squares for the first 100 natural numbers.
- Approach tried: loop from 1..100 to accumulate sum and sum-of-squares directly.
- Optimization tried: closed-form arithmetic series formulas for sum and sum-of-squares.
- Measured observation: direct loop measured 583 ns vs formula-based method 41 ns in one run (about 14.22x speedup).
- Learning: when a closed form exists, it can remove iteration overhead and materially improve runtime even on small fixed limits.

## Problem 7
- Goal: find the 10001st prime number.
- Baseline approach tried: increment candidates and test primality with trial division up to sqrt(n).
- Optimization tried: sieve of Eratosthenes up to an analytic upper bound for the nth prime.
- Measured observation: baseline measured 10184792 ns vs sieve approach 4826167 ns in one run (about 2.11x speedup).
- Learning: for medium-size prime-index queries, precomputation with a sieve gives clear gains and predictable scaling.

## Problem 8
- Goal: largest product of 13 adjacent digits in a fixed 1000-digit series.
- Baseline approach tried: compute each window product from scratch with 13 multiplications.
- Optimizations tried:
	- sliding window with rolling product and zero-count tracking
	- functional C++20 ranges/lambda pipeline (Scala-style map/fold/max)
	- functional-hybrid approach that first splits on zeros, then runs rolling products per non-zero segment
- Measured observation: in one 20-run comparison, functional averaged 72708.30 ns, functional-hybrid averaged 53422.85 ns, and imperative rolling-window averaged 32902.00 ns.
- Learning: segmenting by zeros recovers a good chunk of functional overhead, but imperative rolling windows still had the best runtime in these measurements.

## Problem 9
- Goal: find the unique Pythagorean triplet with a + b + c = 1000 and return abc.
- Baseline approach tried: brute-force nested loops for a, b, c with sum and Pythagorean checks.
- Optimization tried: algebraic reduction to solve b from a and the fixed sum, reducing search to a single loop.
- Measured observation: baseline measured 72501666 ns vs algebraic approach 458 ns in one run (about 158301x speedup).
- Learning: reducing dimensionality of the search space with math identities can outperform brute force by orders of magnitude.

## Problem 10
- Goal: sum all prime numbers below two million.
- Baseline approach tried: test each candidate with trial division primality checks.
- Optimization tried: sieve of Eratosthenes and accumulate flagged primes.
- Measured observation: baseline measured 91068334 ns vs sieve approach 36305000 ns in one run (about 2.51x speedup).
- Learning: sieve precomputation gives strong gains for aggregate prime queries and scales better than repeated trial division.

## Problem 11
- Goal: largest product of 4 adjacent values in a 20x20 grid over all directions.
- Baseline approach tried: per-cell search over 8 direction vectors with bounds checks.
- Optimization tried: directional loop specialization (horizontal/vertical/two diagonals) without per-step bounds branching.
- Measured observation: baseline measured 32167 ns vs specialized loops 2667 ns in one run (about 12.06x speedup).
- Learning: removing repeated bounds checks and direction indirection can materially speed fixed-grid scans.

## Problem 12
- Goal: first triangular number with more than 500 divisors.
- Baseline approach tried: iterate triangle numbers and count divisors via sqrt scan.
- Optimization tried: factor-count decomposition on n(n+1)/2 using coprime parts.
- Measured observation: baseline measured 41381792 ns vs factorized approach 792416 ns in one run (about 52.22x speedup).
- Learning: exploiting triangle-number structure plus prime exponents is far more effective than repeated generic divisor scans.

## Problem 13
- Goal: first ten digits of the sum of 100 fifty-digit numbers.
- Baseline approach tried: exact column-wise manual big-integer addition.
- Optimization tried: sum leading digit prefixes sufficient to determine the first ten digits.
- Measured observation: baseline measured 55291 ns vs prefix-sum method 3917 ns in one run (about 14.12x speedup).
- Learning: when only leading digits are required, controlled approximation can greatly reduce work.

## Problem 14
- Goal: starting number under one million that produces the longest Collatz chain.
- Baseline approach tried: plain chain-length evaluation for each start without caching.
- Optimization tried: memoized chain lengths for repeated subproblems.
- Measured observation: baseline measured 485080209 ns vs memoized approach 23748167 ns in one run (about 20.43x speedup).
- Learning: Collatz exploration has heavy overlap; memoization removes repeated traversal cost.

## Problem 15
- Goal: count lattice paths through a 20x20 grid moving right/down.
- Baseline approach tried: dynamic programming over grid path counts.
- Optimization tried: direct combinatorial computation of binomial coefficient C(40,20).
- Measured observation: baseline measured 37166 ns vs combinatorial method 1125 ns in one run (about 33.04x speedup).
- Learning: closed-form combinatorics can replace DP for fixed rectangular path counting.

## Problem 16
- Goal: sum digits of 2^1000.
- Baseline approach tried: base-10 digit-vector doubling.
- Optimization tried: chunked big-integer representation (base 1e9) for fewer carry operations.
- Measured observation: baseline measured 1925125 ns vs chunked method 195125 ns in one run (about 9.87x speedup).
- Learning: larger internal numeric bases can significantly reduce big-integer loop overhead.

## Problem 17
- Goal: letter count for writing 1..1000 in words (British usage).
- Baseline approach tried: generate each phrase and count alphabetic characters.
- Optimization tried: direct arithmetic count from reusable word-length components.
- Measured observation: baseline measured 698834 ns vs formula method 41 ns in one run (about 17044.7x speedup).
- Learning: symbolic counting can collapse repeated string construction to constant-time arithmetic.

## Problem 18
- Goal: maximum path sum from top to bottom of the given triangle.
- Baseline approach tried: exhaustive recursive DFS over both child choices.
- Optimization tried: bottom-up dynamic programming collapse.
- Measured observation: baseline measured 473583 ns vs bottom-up DP 21667 ns in one run (about 21.86x speedup).
- Learning: bottom-up DP avoids repeated subproblem evaluation in path-aggregation trees.

## Problem 19
- Goal: Sundays that fell on the first of the month during 1901-2000.
- Baseline approach tried: month-by-month date progression with weekday rollover.
- Optimization tried: direct weekday formula on each month start date.
- Measured observation: baseline measured 16708 ns vs formula method 37375 ns in one run (optimized was slower, about 0.45x speedup).
- Learning: for tiny bounded loops, simpler simulation can outperform formula-heavy alternatives.

## Problem 20
- Goal: sum digits of 100!.
- Baseline approach tried: base-10 big-integer multiplication.
- Optimization tried: chunked big-integer multiplication in base 1e9.
- Measured observation: baseline measured 106209 ns vs chunked method 16875 ns in one run (about 6.29x speedup).
- Learning: compact chunk-based arithmetic improves multiplication performance for moderate-size factorials.

## Problem 21
- Goal: sum all amicable numbers below 10000.
- Baseline approach tried: on-demand divisor-sum computation per candidate.
- Optimization tried: sieve-style precomputation of proper-divisor sums.
- Measured observation: baseline measured 5206208 ns vs precompute method 738792 ns in one run (about 7.05x speedup).
- Learning: precomputing divisor aggregates is effective when many related queries share the same bound.

## Problem 22
- Goal: total name scores from the provided name list file.
- Baseline approach tried: parse names, sort, and compute alphabetical score directly per name.
- Optimization tried: same pipeline with precomputed letter scores to reduce repeated char arithmetic.
- Measured observation: baseline measured 10795958 ns vs precomputed-letter method 6837333 ns in one run (about 1.58x speedup).
- Learning: in file/sort-dominated workflows, micro-optimizations in inner scoring loops give only modest gains.

## Notes For Future Problems
- Add one section per problem with: goal, approach, tried learning(s), and measured notes when available.
- If you compare approaches, capture both correctness and rough timing.
- Keep notes short and practical.
