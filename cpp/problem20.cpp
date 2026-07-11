/*
https://projecteuler.net/problem=20

Factorial digit sum

Find the sum of the digits in the number 100!
*/

#include <chrono>
#include <iostream>
#include <vector>
using namespace std;

struct result {
    long long value;
    long long time_ns;
};

long long evaluate_baseline() {
    std::vector<int> digits(1, 1);

    for (int n = 2; n <= 100; ++n) {
        int carry = 0;
        for (size_t i = 0; i < digits.size(); ++i) {
            int v = digits[i] * n + carry;
            digits[i] = v % 10;
            carry = v / 10;
        }
        while (carry > 0) {
            digits.push_back(carry % 10);
            carry /= 10;
        }
    }

    long long sum = 0;
    for (int d : digits) sum += d;
    return sum;
}

long long evaluate_optimized() {
    const int BASE = 1000000000;
    std::vector<int> chunks(1, 1);

    for (int n = 2; n <= 100; ++n) {
        long long carry = 0;
        for (size_t i = 0; i < chunks.size(); ++i) {
            long long v = 1LL * chunks[i] * n + carry;
            chunks[i] = static_cast<int>(v % BASE);
            carry = v / BASE;
        }
        while (carry > 0) {
            chunks.push_back(static_cast<int>(carry % BASE));
            carry /= BASE;
        }
    }

    long long sum = 0;
    for (size_t i = 0; i < chunks.size(); ++i) {
        int part = chunks[i];
        int width = (i + 1 == chunks.size()) ? 0 : 9;
        int count = 0;

        if (part == 0) {
            ++count;
        }

        while (part > 0) {
            sum += part % 10;
            part /= 10;
            ++count;
        }

        while (count < width) {
            ++count;
        }
    }

    return sum;
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
    std::cout << "Project Euler Problem 20" << std::endl;

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
