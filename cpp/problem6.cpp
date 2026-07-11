/*
https://projecteuler.net/problem=6

Sum square difference

The sum of the squares of the first ten natural numbers is,
1^2 + 2^2 + ... + 10^2 = 385

The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)^2 = 55^2 = 3025

Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is,
3025 - 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/

#include <chrono>
#include <iostream>
using namespace std;

struct result {
    long long value;
    long long time_ns;
};

long long evaluate_baseline() {
    const long long limit = 100;
    long long sum = 0;
    long long sum_of_squares = 0;

    for (long long i = 1; i <= limit; ++i) {
        sum += i;
        sum_of_squares += i * i;
    }

    long long square_of_sum = sum * sum;
    return square_of_sum - sum_of_squares;
}

long long evaluate_optimized() {
    const long long n = 100;
    const long long sum = n * (n + 1) / 2;
    const long long sum_of_squares = n * (n + 1) * (2 * n + 1) / 6;
    return sum * sum - sum_of_squares;
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
    std::cout << "Project Euler Problem 6" << std::endl;

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
