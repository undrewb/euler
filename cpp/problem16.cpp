/*
https://projecteuler.net/problem=16

Power digit sum

What is the sum of the digits of the number 2^1000?
*/

#include <chrono>
#include <iostream>
#include <string>
#include <vector>
using namespace std;

struct result {
    long long value;
    long long time_ns;
};

int digit_sum_base10(std::vector<int> d) {
    int sum = 0;
    for (int x : d) sum += x;
    return sum;
}

long long evaluate_baseline() {
    std::vector<int> digits(1, 1);

    for (int i = 0; i < 1000; ++i) {
        int carry = 0;
        for (size_t j = 0; j < digits.size(); ++j) {
            int v = digits[j] * 2 + carry;
            digits[j] = v % 10;
            carry = v / 10;
        }
        while (carry > 0) {
            digits.push_back(carry % 10);
            carry /= 10;
        }
    }

    return digit_sum_base10(digits);
}

long long evaluate_optimized() {
    const int BASE = 1000000000;
    std::vector<int> chunks(1, 1);

    for (int i = 0; i < 1000; ++i) {
        long long carry = 0;
        for (size_t j = 0; j < chunks.size(); ++j) {
            long long v = 2LL * chunks[j] + carry;
            chunks[j] = static_cast<int>(v % BASE);
            carry = v / BASE;
        }
        if (carry > 0) {
            chunks.push_back(static_cast<int>(carry));
        }
    }

    long long sum = 0;
    for (size_t i = 0; i < chunks.size(); ++i) {
        int part = chunks[i];
        int width = (i + 1 == chunks.size()) ? 0 : 9;
        int count = 0;

        if (part == 0) {
            count = 1;
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
    std::cout << "Project Euler Problem 16" << std::endl;

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
