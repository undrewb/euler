/*
https://projecteuler.net/problem=8

Largest product in a series (functional hybrid C++20 style)

A functional-leaning pipeline that splits on zeros, then uses a rolling
product per non-zero segment.
*/

#include <algorithm>
#include <chrono>
#include <iostream>
#include <ranges>
#include <string_view>
#include <vector>
using namespace std;

struct result {
    long long value;
    long long time_ns;
};

std::string_view n_str() {
    return
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
}

long long max_product_nonzero_segment(const std::vector<int>& segment, size_t window) {
    if (segment.size() < window) {
        return 0;
    }

    long long product = 1;
    for (size_t i = 0; i < window; ++i) {
        product *= segment[i];
    }

    long long best = product;
    for (size_t i = window; i < segment.size(); ++i) {
        product /= segment[i - window];
        product *= segment[i];
        if (product > best) {
            best = product;
        }
    }

    return best;
}

long long answer() {
    constexpr size_t window = 13;
    const std::string_view s = n_str();

    std::vector<std::vector<int>> segments;
    segments.reserve(64);

    std::vector<int> current;
    current.reserve(64);

    for (char c : s) {
        int d = c - '0';
        if (d == 0) {
            if (!current.empty()) {
                segments.push_back(std::move(current));
                current.clear();
                current.reserve(64);
            }
        } else {
            current.push_back(d);
        }
    }
    if (!current.empty()) {
        segments.push_back(std::move(current));
    }

    const auto candidates = segments | std::views::transform([window](const std::vector<int>& seg) {
                                return max_product_nonzero_segment(seg, window);
                            });

    return std::ranges::max(candidates);
}

result euler() {
    const auto start = std::chrono::steady_clock::now();
    long long value = answer();
    const auto end = std::chrono::steady_clock::now();
    long long elapsed = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();
    return {value, elapsed};
}

int main() {
    std::cout << "Project Euler Problem 8 (functional hybrid C++20)" << std::endl;
    result r = euler();
    std::cout << "Result: " << r.value << std::endl;
    std::cout << "Evaluation time: " << r.time_ns << " ns" << std::endl;
    return 0;
}
