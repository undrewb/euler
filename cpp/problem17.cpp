/*
https://projecteuler.net/problem=17

Number letter counts

If all the numbers from 1 to 1000 (one thousand) inclusive were written out
in words, how many letters would be used?
*/

#include <chrono>
#include <cctype>
#include <iostream>
#include <string>
using namespace std;

struct result {
    long long value;
    long long time_ns;
};

std::string to_words(int n) {
    static const std::string ones[] = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                                       "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    static const std::string tens[] = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    if (n == 1000) return "one thousand";

    std::string out;
    if (n >= 100) {
        out += ones[n / 100] + " hundred";
        if (n % 100 != 0) {
            out += " and ";
        }
        n %= 100;
    }

    if (n >= 20) {
        out += tens[n / 10];
        if (n % 10 != 0) {
            out += "-" + ones[n % 10];
        }
    } else if (n > 0) {
        out += ones[n];
    }

    return out;
}

long long evaluate_baseline() {
    long long total = 0;
    for (int n = 1; n <= 1000; ++n) {
        std::string s = to_words(n);
        for (char ch : s) {
            if (std::isalpha(static_cast<unsigned char>(ch))) {
                ++total;
            }
        }
    }
    return total;
}

long long evaluate_optimized() {
    const int ones_1_to_9 = 3 + 3 + 5 + 4 + 4 + 3 + 5 + 5 + 4;
    const int teens_10_to_19 = 3 + 6 + 6 + 8 + 8 + 7 + 7 + 9 + 8 + 8;
    const int tens_20_to_90 = 6 + 6 + 5 + 5 + 5 + 7 + 6 + 6;

    int one_to_99 = ones_1_to_9 + teens_10_to_19 + 10 * tens_20_to_90 + 8 * ones_1_to_9;

    int hundred_word = 7;
    int and_word = 3;

    long long total = one_to_99;
    total += 100 * ones_1_to_9;
    total += 9 * 100 * hundred_word;
    total += 9 * 99 * and_word;
    total += 9 * one_to_99;
    total += 3 + 8;

    return total;
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
    std::cout << "Project Euler Problem 17" << std::endl;

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
