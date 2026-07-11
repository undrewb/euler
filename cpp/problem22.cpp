/*
https://projecteuler.net/problem=22

Names scores

Using 0022_names.txt, sort the names and compute total name scores.
*/

#include <algorithm>
#include <chrono>
#include <fstream>
#include <iostream>
#include <sstream>
#include <string>
#include <vector>
using namespace std;

struct result {
    long long value;
    long long time_ns;
};

std::vector<std::string> load_names() {
    std::ifstream in("0022_names.txt");
    std::vector<std::string> names;

    if (!in) {
        return names;
    }

    std::string content;
    std::getline(in, content);

    std::stringstream ss(content);
    std::string token;
    while (std::getline(ss, token, ',')) {
        if (!token.empty() && token.front() == '"' && token.back() == '"') {
            token = token.substr(1, token.size() - 2);
        }
        names.push_back(token);
    }

    return names;
}

int name_value(const std::string &name) {
    int v = 0;
    for (char c : name) {
        v += (c - 'A' + 1);
    }
    return v;
}

long long evaluate_baseline() {
    std::vector<std::string> names = load_names();
    if (names.empty()) {
        return -1;
    }

    std::sort(names.begin(), names.end());

    long long total = 0;
    for (size_t i = 0; i < names.size(); ++i) {
        total += static_cast<long long>(i + 1) * name_value(names[i]);
    }
    return total;
}

long long evaluate_optimized() {
    std::vector<std::string> names = load_names();
    if (names.empty()) {
        return -1;
    }

    std::sort(names.begin(), names.end());

    int letter_score[26];
    for (int i = 0; i < 26; ++i) {
        letter_score[i] = i + 1;
    }

    long long total = 0;
    for (size_t i = 0; i < names.size(); ++i) {
        int value = 0;
        for (char c : names[i]) {
            value += letter_score[c - 'A'];
        }
        total += static_cast<long long>(i + 1) * value;
    }

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
    std::cout << "Project Euler Problem 22" << std::endl;

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
