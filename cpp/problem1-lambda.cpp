/*
https://projecteuler.net/problem=1

Multiples of 3 or 5

If we list all the natural numbers below 10 that are multiples of 3 or 5, we
get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
*/

#include <array>
#include <chrono>
#include <iostream>
#include <numeric>

struct result {
    int value;
    long long time_ns;
};

int evaluate() {
    std::array<int, 1000> values{};
    std::iota(values.begin(), values.end(), 0);

    auto is_multiple = [](int value) {
        return value % 3 == 0 || value % 5 == 0;
    };

    return std::accumulate(values.begin(), values.end(), 0,
                           [is_multiple](int acc, int value) {
                               return is_multiple(value) ? acc + value : acc;
                           });
}

result euler() {
    const auto start = std::chrono::steady_clock::now();
    int value = evaluate();
    const auto end = std::chrono::steady_clock::now();
    long long elapsed = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();
    return {value, elapsed};
}

int main() {
    std::cout << "Project Euler Problem 1 (lambda)" << std::endl;
    result r = euler();
    std::cout << "Result: " << r.value << std::endl;
    std::cout << "Evaluation time: " << r.time_ns << " ns" << std::endl;
    return 0;
}