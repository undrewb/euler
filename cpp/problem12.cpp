/*
https://projecteuler.net/problem=12

Highly divisible triangular number

What is the value of the first triangle number to have over five hundred divisors?
*/

#include <chrono>
#include <iostream>
using namespace std;

struct result {
    long long value;
    long long time_ns;
};

int count_divisors_sqrt(long long n) {
    int count = 0;
    for (long long d = 1; d * d <= n; ++d) {
        if (n % d == 0) {
            count += 2;
            if (d * d == n) {
                --count;
            }
        }
    }
    return count;
}

int count_divisors_factorized(long long n) {
    int total = 1;
    int exp = 0;
    while (n % 2 == 0) {
        n /= 2;
        ++exp;
    }
    if (exp > 0) {
        total *= (exp + 1);
    }

    for (long long p = 3; p * p <= n; p += 2) {
        exp = 0;
        while (n % p == 0) {
            n /= p;
            ++exp;
        }
        if (exp > 0) {
            total *= (exp + 1);
        }
    }

    if (n > 1) {
        total *= 2;
    }

    return total;
}

long long evaluate_baseline() {
    const int target = 500;
    long long triangle = 0;

    for (long long n = 1;; ++n) {
        triangle += n;
        if (count_divisors_sqrt(triangle) > target) {
            return triangle;
        }
    }
}

long long evaluate_optimized() {
    const int target = 500;

    for (long long n = 1;; ++n) {
        long long a = n;
        long long b = n + 1;

        if (a % 2 == 0) {
            a /= 2;
        } else {
            b /= 2;
        }

        int divisors = count_divisors_factorized(a) * count_divisors_factorized(b);
        if (divisors > target) {
            return n * (n + 1) / 2;
        }
    }
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
    std::cout << "Project Euler Problem 12" << std::endl;

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
