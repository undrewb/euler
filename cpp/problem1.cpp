/*

https://projecteuler.net/problem=1

If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
Find the sum of all the multiples of 3 or 5 below 1000.

*/

#include <chrono>
#include <iostream>
using namespace std;

struct result {
    int value;
    long long time_ns;
};

int evaluate() {
    int sum = 0;
    for (int i = 0; i < 1000; ++i) {
        if (i % 3 == 0 || i % 5 == 0) {
            sum += i;
        }
    }
    return sum;
}

result euler() {
    const auto start = std::chrono::steady_clock::now();
    int result = evaluate();
    const auto end = std::chrono::steady_clock::now();
    long long elapsed = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();
    return {result, elapsed};
}

int main() { 
    std::cout << "Project Euler Problem 1" << std::endl;
    result r = euler();
    std::cout << "Result: " << r.value << std::endl;
    std::cout << "Evaluation time: " << r.time_ns << " ns" << std::endl;
    return 0;
}
