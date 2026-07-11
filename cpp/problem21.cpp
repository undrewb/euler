/*
https://projecteuler.net/problem=21

Amicable numbers

Evaluate the sum of all the amicable numbers under 10000.
*/

#include <chrono>
#include <iostream>
#include <vector>
using namespace std;

struct result {
    long long value;
    long long time_ns;
};

int sum_proper_divisors_naive(int n) {
    if (n <= 1) return 0;
    int sum = 1;
    for (int d = 2; d * d <= n; ++d) {
        if (n % d == 0) {
            sum += d;
            if (d * d != n) {
                sum += n / d;
            }
        }
    }
    return sum;
}

long long evaluate_baseline() {
    const int limit = 10000;
    long long total = 0;

    for (int a = 2; a < limit; ++a) {
        int b = sum_proper_divisors_naive(a);
        if (b != a && sum_proper_divisors_naive(b) == a) {
            total += a;
        }
    }

    return total;
}

long long evaluate_optimized() {
    const int limit = 10000;
    std::vector<int> sum_div(limit + 1, 0);

    for (int d = 1; d <= limit / 2; ++d) {
        for (int m = 2 * d; m <= limit; m += d) {
            sum_div[m] += d;
        }
    }

    long long total = 0;
    for (int a = 2; a < limit; ++a) {
        int b = sum_div[a];
        if (b != a && b <= limit && sum_div[b] == a) {
            total += a;
        } else if (b != a && b > limit) {
            if (sum_proper_divisors_naive(b) == a) {
                total += a;
            }
        }
    }

    return total;
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
    std::cout << "Project Euler Problem 21" << std::endl;

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
