/*
https://projecteuler.net/problem=9

Special Pythagorean triplet

A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a^2 + b^2 = c^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
*/

#include <chrono>
#include <iostream>
using namespace std;

struct result {
    long long value;
    long long time_ns;
};

long long evaluate_baseline() {
    const int target_sum = 1000;

    for (int a = 1; a < target_sum; ++a) {
        for (int b = a + 1; b < target_sum; ++b) {
            for (int c = b + 1; c < target_sum; ++c) {
                if (a + b + c != target_sum) {
                    continue;
                }
                if (a * a + b * b == c * c) {
                    return static_cast<long long>(a) * b * c;
                }
            }
        }
    }

    return -1;
}

long long evaluate_optimized() {
    const int target_sum = 1000;

    for (int a = 1; a < target_sum / 3; ++a) {
        const int numerator = target_sum * (target_sum - 2 * a);
        const int denominator = 2 * (target_sum - a);

        if (denominator == 0 || numerator % denominator != 0) {
            continue;
        }

        const int b = numerator / denominator;
        const int c = target_sum - a - b;

        if (a < b && b < c && a * a + b * b == c * c) {
            return static_cast<long long>(a) * b * c;
        }
    }

    return -1;
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
    std::cout << "Project Euler Problem 9" << std::endl;

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
