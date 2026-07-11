/*
https://projecteuler.net/problem=23

Non-abundant sums

A perfect number is a number for which the sum of its proper divisors is exactly
equal to the number. For example, the sum of the proper divisors of 28 would be
1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n
and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
number that can be written as the sum of two abundant numbers is 24. By
mathematical analysis, it can be shown that all integers greater than 28123 can
be written as the sum of two abundant numbers. However, this upper limit cannot
be reduced any further by analysis even though it is known that the greatest
number that cannot be expressed as the sum of two abundant numbers is less than
this limit.

Find the sum of all the positive integers which cannot be written as the sum of
two abundant numbers.

No-spoiler scaffold:
- Keep baseline and optimized paths separate.
- Measure both.
- Do not hardcode or print known final answers.
*/

#include <chrono>
#include <iostream>
#include <vector>

using namespace std;

struct result {
    long long value;
    long long time_ns;
};
// A number n is called deficient if the sum of its proper divisors is less than n
// and it is called abundant if this sum exceeds n.

bool is_abundant(int n) {
    int sum = 1; // 1 is a proper divisor of all n > 1
    for (int i = 2; i * i <= n; ++i) {
        if (n % i == 0) {
            sum += i;
            if (i != n / i) {
                sum += n / i;
            }
        }
    }
    return sum > n;
}

bool isSumOfAbundantPair(int n) {
    // TODO check if n can be expressed as the sum of two abundant numbers
    if (n < 24) {
        return false;
    }
    if (n > 28123) {
        return true;
    }
    for (int i = 12; i <= n / 2; ++i) {
        if ( is_abundant(i) && is_abundant(n - i)) {
            return true;
        }
    }   
    return false;
}

long long evaluate_baseline() {
    long long sum = 0;
    for (int i = 1; i <= 28123; ++i) {
        if (!isSumOfAbundantPair(i)) {
            sum += i;
        }
        // TODO compute sum of proper divisors of i
        // TODO check if i is abundant
    }
    // TODO baseline idea (simple and correct first):
    // 1) Build helper to compute sum of proper divisors.
    // 2) Collect abundant numbers up to 28123.
    // 3) Mark all sums of two abundant numbers in a boolean table.
    // 4) Sum numbers that were never marked.
    return sum;
}

long long evaluate_optimized() {
    constexpr int limit = 28123;

    // sum_divisors[n] stores the sum of proper divisors of n.
    vector<int> sum_divisors(limit + 1, 0);
    for (int d = 1; d <= limit / 2; ++d) {
        for (int multiple = d * 2; multiple <= limit; multiple += d) {
            sum_divisors[multiple] += d;
        }
    }

    vector<int> abundant;
    abundant.reserve(limit / 2);
    for (int n = 12; n <= limit; ++n) {
        if (sum_divisors[n] > n) {
            abundant.push_back(n);
        }
    }

    vector<bool> can_be_written(limit + 1, false);
    for (size_t i = 0; i < abundant.size(); ++i) {
        for (size_t j = i; j < abundant.size(); ++j) {
            int s = abundant[i] + abundant[j];
            if (s > limit) {
                break;
            }
            can_be_written[s] = true;
        }
    }

    long long sum = 0;
    for (int n = 1; n <= limit; ++n) {
        if (!can_be_written[n]) {
            sum += n;
        }
    }

    return sum;
}

result euler_baseline() {
    const auto start = chrono::steady_clock::now();
    long long value = evaluate_baseline();
    const auto end = chrono::steady_clock::now();
    long long elapsed = chrono::duration_cast<chrono::nanoseconds>(end - start).count();
    return {value, elapsed};
}

result euler() {
    const auto start = chrono::steady_clock::now();
    long long value = evaluate_optimized();
    const auto end = chrono::steady_clock::now();
    long long elapsed = chrono::duration_cast<chrono::nanoseconds>(end - start).count();
    return {value, elapsed};
}

int main() {
    cout << "Project Euler Problem 23" << endl;

    result baseline = euler_baseline();
    result optimized = euler();

    cout << "Result (baseline): " << baseline.value << endl;
    cout << "Time (baseline): " << baseline.time_ns << " ns" << endl;
    cout << "Result (optimized): " << optimized.value << endl;
    cout << "Time (optimized): " << optimized.time_ns << " ns" << endl;

    if (optimized.time_ns > 0) {
        double speedup = static_cast<double>(baseline.time_ns) / static_cast<double>(optimized.time_ns);
        cout << "Speedup: " << speedup << "x" << endl;
    }

    return 0;
}