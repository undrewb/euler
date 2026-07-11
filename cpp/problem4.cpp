/*
https://projecteuler.net/problem=4

Largest palindrome product

A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009.

Find the largest palindrome made from the product of two 3-digit numbers.

*/

#include <chrono>
#include <iostream>
using namespace std;

struct result {
    int value;
    long long time_ns;
};

bool is_palindrome(int n) {
    int reversed = 0;
    int temp = n;
    while (temp > 0) {
        reversed = reversed * 10 + temp % 10;
        temp /= 10;
    }
    return n == reversed;
}

int evaluate_baseline() {
    int max_palindrome = 0;
    for (int i = 100; i <= 999; ++i) {
        for (int j = i; j <= 999; ++j) {
            int product = i * j;
            if (product > max_palindrome && is_palindrome(product)) {
                max_palindrome = product;
            }
        }
    }
    return max_palindrome;
}

int evaluate_optimized() {
    int max_palindrome = 0;

    for (int i = 999; i >= 100; --i) {
        // Prune outer loop: with this i, the biggest possible product is i * 999.
        // If even that cannot beat the best palindrome we already have, smaller i
        // values cannot help either, so we can stop completely.
        if (i * 999 < max_palindrome) {
            break;
        }

        int j_start = 999;
        int step = 1;

        // For 6-digit palindromes abccba:
        //   abccba = 100001a + 10010b + 1100c = 11(9091a + 910b + 100c).
        // So any 6-digit palindrome is divisible by 11, meaning at least one
        // factor must be a multiple of 11. If i is not divisible by 11, force
        // j to move through multiples of 11 only.
        if (i % 11 != 0) {
            j_start = 990;
            step = 11;
        }

        for (int j = j_start; j >= i; j -= step) {
            int product = i * j;
            // Prune inner loop: j only decreases from here, so products only get
            // smaller. Once product <= current best, no later j can improve it.
            if (product <= max_palindrome) {
                break;
            }
            if (is_palindrome(product)) {
                max_palindrome = product;
            }
        }
    }

    return max_palindrome;
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
    std::cout << "Project Euler Problem 4" << std::endl;

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
