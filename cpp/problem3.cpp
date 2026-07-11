/*
https://projecteuler.net/problem=3

The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143?
    
*/

#include <chrono>
#include <iostream>
using namespace std;

struct result {
    int value;
    long long time_ns;
};

bool is_prime(long long n) {
    if (n <= 1) return false;
    if (n <= 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;
    for (long long i = 5; i * i <= n; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0) return false;
    }
    return true;
}

int evaluate() {
    long long n = 600851475143;
    int largest_prime = -1;

    // Check for number of 2s that divide n
    while (n % 2 == 0) {
        largest_prime = 2;
        n /= 2;
    }

    // n must be odd at this point, so we can skip even numbers
    for (int i = 3; i * i <= n; i += 2) {
        while (n % i == 0) {
            largest_prime = i;
            n /= i;
        }
    }

    // This condition is to check if n is a prime number greater than 2
    if (n > 2) {
        largest_prime = n;
    }

    return largest_prime;
}

int evaluate_with_is_prime() {
    const long long target = 600851475143;
    int largest_prime = -1;

    for (long long i = 2; i * i <= target; ++i) {
        if (target % i == 0) {
            const long long other = target / i;
            if (is_prime(i)) {
                largest_prime = static_cast<int>(i);
            }
            if (is_prime(other)) {
                largest_prime = static_cast<int>(other);
            }
        }
    }

    return largest_prime;
}

result euler() {
    const auto start = std::chrono::steady_clock::now();
    int result = evaluate();
    const auto end = std::chrono::steady_clock::now();
    long long elapsed = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();
    return {result, elapsed};
}

result euler_with_is_prime() {
    const auto start = std::chrono::steady_clock::now();
    int result = evaluate_with_is_prime();
    const auto end = std::chrono::steady_clock::now();
    long long elapsed = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();
    return {result, elapsed};
}

int main() { 
    std::cout << "Project Euler Problem 3" << std::endl;
    result fast = euler();
    result with_is_prime = euler_with_is_prime();

    std::cout << "Result (factorization): " << fast.value << std::endl;
    std::cout << "Time (factorization): " << fast.time_ns << " ns" << std::endl;
    std::cout << "Result (using is_prime): " << with_is_prime.value << std::endl;
    std::cout << "Time (using is_prime): " << with_is_prime.time_ns << " ns" << std::endl;

    if (fast.time_ns > 0) {
        double slowdown = static_cast<double>(with_is_prime.time_ns) / static_cast<double>(fast.time_ns);
        std::cout << "Slowdown: " << slowdown << "x" << std::endl;
    }

    return 0;
}