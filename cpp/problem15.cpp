/*
https://projecteuler.net/problem=15

Lattice paths

How many routes are there through a 20x20 grid moving only right and down?
*/

#include <chrono>
#include <iostream>
#include <numeric>
#include <vector>
using namespace std;

struct result {
    long long value;
    long long time_ns;
};

long long evaluate_baseline() {
    const int n = 20;
    std::vector<std::vector<long long>> dp(n + 1, std::vector<long long>(n + 1, 0));

    for (int i = 0; i <= n; ++i) {
        dp[i][0] = 1;
        dp[0][i] = 1;
    }

    for (int r = 1; r <= n; ++r) {
        for (int c = 1; c <= n; ++c) {
            dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
        }
    }

    return dp[n][n];
}

long long evaluate_optimized() {
    const int n = 20;
    const int k = 20;

    __int128 result = 1;
    for (int i = 1; i <= k; ++i) {
        result = result * (n + i) / i;
    }

    return static_cast<long long>(result);
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
    std::cout << "Project Euler Problem 15" << std::endl;

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
