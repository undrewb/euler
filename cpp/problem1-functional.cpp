/*
https://projecteuler.net/problem=1

Multiples of 3 or 5 (functional C++20 style)

If we list all the natural numbers below 10 that are multiples of 3 or 5,
we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
*/

#include <chrono>
#include <iostream>
#include <numeric>
#include <ranges>

struct result {
    int value;
    long long time_ns;
};

int answer() {
    auto values = std::views::iota(0, 1000)
        | std::views::filter([](int n) { return n % 3 == 0 || n % 5 == 0; });

    return std::accumulate(values.begin(), values.end(), 0);
}

result euler() {
    const auto start = std::chrono::steady_clock::now();
    int value = answer();
    const auto end = std::chrono::steady_clock::now();
    long long elapsed = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();
    return {value, elapsed};
}

int main() {
    std::cout << "Project Euler Problem 1 (functional C++20)" << std::endl;
    result r = euler();
    std::cout << "Result: " << r.value << std::endl;
    std::cout << "Evaluation time: " << r.time_ns << " ns" << std::endl;
    return 0;
}
