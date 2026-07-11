/*
https://projecteuler.net/problem=14

Longest Collatz sequence

Which starting number, under one million, produces the longest Collatz chain?
*/

#include <chrono>
#include <iostream>
#include <vector>
using namespace std;

struct result {
    long long value;
    long long time_ns;
};

long long collatz_length_plain(long long n) {
    long long len = 1;
    while (n != 1) {
        if (n % 2 == 0) {
            n /= 2;
        } else {
            n = 3 * n + 1;
        }
        ++len;
    }
    return len;
}

long long evaluate_baseline() {
    long long best_start = 1;
    long long best_len = 1;

    for (long long n = 1; n < 1000000; ++n) {
        long long len = collatz_length_plain(n);
        if (len > best_len) {
            best_len = len;
            best_start = n;
        }
    }

    return best_start;
}

long long collatz_length_memo(long long n, std::vector<int> &memo) {
    if (n < static_cast<long long>(memo.size()) && memo[n] != 0) {
        return memo[n];
    }

    long long next = (n % 2 == 0) ? (n / 2) : (3 * n + 1);
    long long len = 1 + collatz_length_memo(next, memo);

    if (n < static_cast<long long>(memo.size())) {
        memo[n] = static_cast<int>(len);
    }

    return len;
}

long long evaluate_optimized() {
    std::vector<int> memo(1000000, 0);
    memo[1] = 1;

    long long best_start = 1;
    long long best_len = 1;

    for (long long n = 1; n < 1000000; ++n) {
        long long len = collatz_length_memo(n, memo);
        if (len > best_len) {
            best_len = len;
            best_start = n;
        }
    }

    return best_start;
}

result euler() {
    const auto start = std::chrono::steady_clock::now();
    long long value = evaluate_optimized();
    const auto end = std::chrono::steady_clock::now();
    long long elapsed = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();
    return {value, elapsed};
}

result euler_baseline() {
    const auto start = std::chrono::steady_clock::now();
    long long value = evaluate_baseline();
    const auto end = std::chrono::steady_clock::now();
    long long elapsed = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();
    return {value, elapsed};
}

int main() {
    std::cout << "Project Euler Problem 14" << std::endl;

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
