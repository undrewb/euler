# Problem 22 Lambda Notes

This version is the most natural lambda exercise of the three because the problem
has several small transformations that map neatly onto local function objects.

## What Changed

- `strip_quotes` is a lambda used while tokenising the CSV input.
- `letter_value` isolates the character-to-score rule.
- `name_value` uses `std::accumulate` with a nested lambda to sum letter scores.
- `score_at` turns the sorted name at a given index into its weighted score.

## Sample Performance

Compiled with `c++ -std=c++20 -O2` and run once from the `cpp/` directory.

| Version | Result | Time |
| --- | ---: | ---: |
| `problem22.cpp` baseline | 871198282 | 4947417 ns |
| `problem22.cpp` optimized | 871198282 | 1067208 ns |
| `problem22-lambda.cpp` | 871198282 | 1792334 ns |

On this run, the lambda version was about `1.68x` slower than the original
optimized implementation, but still about `2.76x` faster than the original
baseline. That makes it a good practice file for lambdas because the code stays
expressive without becoming unreasonably slow.