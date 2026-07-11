/*
https://projecteuler.net/problem=7

10001st prime

By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
we can see that the 6th prime is 13.

What is the 10001st prime number?
*/

#include <chrono>
#include <cmath>
#include <iostream>
#include <vector>
using namespace std;

struct result {
    int value;
    long long time_ns;
};

bool is_prime_basic(int n) {
    if (n < 2) {
        return false;
    }
    for (int d = 2; d * d <= n; ++d) {
        if (n % d == 0) {
            return false;
        }
    }
    return true;
}

int evaluate_baseline() {
    const int target_index = 10001;
    int count = 0;
    int candidate = 1;

    while (count < target_index) {
        ++candidate;
        if (is_prime_basic(candidate)) {
            ++count;
        }
    }

    return candidate;
}

int upper_bound_for_nth_prime(int n) {
    if (n < 6) {
        return 15;
    }

    const double nd = static_cast<double>(n);
    // Rosser's upper bound: p_n < n(log n + log log n) for n >= 6.
    const double bound = nd * (std::log(nd) + std::log(std::log(nd)));
    return static_cast<int>(std::ceil(bound)) + 10;
}

int evaluate_optimized() {
    const int target_index = 10001;
    const int limit = upper_bound_for_nth_prime(target_index);

    std::vector<bool> is_prime(limit + 1, true);
    is_prime[0] = false;
    is_prime[1] = false;

    for (int p = 2; p * p <= limit; ++p) {
        if (!is_prime[p]) {
            continue;
        }
        for (int multiple = p * p; multiple <= limit; multiple += p) {
            is_prime[multiple] = false;
        }
    }

    int count = 0;
    for (int i = 2; i <= limit; ++i) {
        if (is_prime[i]) {
            ++count;
            if (count == target_index) {
                return i;
            }
        }
    }

    return -1;
}

result euler() {
    const auto start = std::chrono::steady_clock::now();
    int value = evaluate_optimized();
    const auto end = std::chrono::steady_clock::now();
    long long elapsed = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();
    return {value, elapsed};
}

result euler_baseline() {
    const auto start = std::chrono::steady_clock::now();
    int value = evaluate_baseline();
    const auto end = std::chrono::steady_clock::now();
    long long elapsed = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();
    return {value, elapsed};
}

int main() {
    std::cout << "Project Euler Problem 7" << std::endl;

    result baseline = euler_baseline();
    result optimized = euler();

    std::cout << "Result (baseline): " << baseline.value << std::endl;
    std::cout << "Time (baseline): " << baseline.time_ns << " ns" << std::endl;
    std::cout << "Result (optimized): " << optimized.value << std::endl;
    std::cout << "Time (optimized): " << optimized.time_ns << " ns" << std::endl;

    if (optimized.time_ns > 0) {
        double speedup = static_cast<double>(baseline.time_ns) / static_cast<double>(optimized.time_ns);
        std::cout << "Speedup: " << speedup << "x" << std::endl;
    }

    return 0;
}
