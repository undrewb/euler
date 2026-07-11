/*
https://projecteuler.net/problem=8

Largest product in a series

The four adjacent digits in the 1000-digit number that have the greatest product are
9 x 9 x 8 x 9 = 5832.

Find the thirteen adjacent digits in the 1000-digit number that have the greatest product.
What is the value of this product?
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

std::vector<int> get_digits() {
    const std::string digits =
        "73167176531330624919225119674426574742355349194934"
        "96983520312774506326239578318016984801869478851843"
        "85861560789112949495459501737958331952853208805511"
        "12540698747158523863050715693290963295227443043557"
        "66896648950445244523161731856403098711121722383113"
        "62229893423380308135336276614282806444486645238749"
        "30358907296290491560440772390713810515859307960866"
        "70172427121883998797908792274921901699720888093776"
        "65727333001053367881220235421809751254540594752243"
        "52584907711670556013604839586446706324415722155397"
        "53697817977846174064955149290862569321978468622482"
        "83972241375657056057490261407972968652414535100474"
        "82166370484403199890008895243450658541227588666881"
        "16427171479924442928230863465674813919123162824586"
        "17866458359124566529476545682848912883142607690042"
        "24219022671055626321111109370544217506941658960408"
        "07198403850962455444362981230987879927244284909188"
        "84580156166097919133875499200524063689912560717606"
        "05886116467109405077541002256983155200055935729725"
        "71636269561882670428252483600823257530420752963450";

    std::vector<int> out;
    out.reserve(digits.size());
    for (char c : digits) {
        out.push_back(c - '0');
    }
    return out;
}

long long evaluate_baseline() {
    const int window = 13;
    const std::vector<int> digits = get_digits();

    long long best = 0;
    for (size_t i = 0; i + window <= digits.size(); ++i) {
        long long product = 1;
        for (int j = 0; j < window; ++j) {
            product *= digits[i + j];
        }
        if (product > best) {
            best = product;
        }
    }

    return best;
}

long long evaluate_optimized() {
    const int window = 13;
    const std::vector<int> digits = get_digits();

    long long best = 0;
    long long product = 1;
    int zero_count = 0;

    for (int i = 0; i < window; ++i) {
        if (digits[i] == 0) {
            ++zero_count;
        } else {
            product *= digits[i];
        }
    }

    for (size_t i = 0; i + window <= digits.size(); ++i) {
        if (zero_count == 0 && product > best) {
            best = product;
        }

        if (i + window == digits.size()) {
            break;
        }

        int outgoing = digits[i];
        int incoming = digits[i + window];

        if (outgoing == 0) {
            --zero_count;
        } else {
            product /= outgoing;
        }

        if (incoming == 0) {
            ++zero_count;
        } else {
            product *= incoming;
        }
    }

    return best;
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
    std::cout << "Project Euler Problem 8" << std::endl;

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
