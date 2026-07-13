/*
https://projecteuler.net/problem=22

Names scores

Using 0022_names.txt, a 46K text file containing over five-thousand first names,
begin by sorting it into alphabetical order. Then working out the alphabetical
value for each name, multiply this value by its alphabetical position in the
list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is
worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would
obtain a score of 938 x 53 = 49714.

What is the total of all the name scores in the file?
*/

#include <algorithm>
#include <chrono>
#include <fstream>
#include <iostream>
#include <numeric>
#include <sstream>
#include <string>
#include <vector>

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
    auto strip_quotes = [](std::string value) {
        if (!value.empty() && value.front() == '"' && value.back() == '"') {
            return value.substr(1, value.size() - 2);
        }
        return value;
    };

    while (std::getline(ss, token, ',')) {
        names.push_back(strip_quotes(token));
    }

    return names;
}

long long evaluate() {
    std::vector<std::string> names = load_names();
    if (names.empty()) {
        return -1;
    }

    std::sort(names.begin(), names.end());

    auto letter_value = [](char c) {
        return c - 'A' + 1;
    };

    auto name_value = [letter_value](const std::string& name) {
        return std::accumulate(name.begin(), name.end(), 0,
                               [letter_value](int acc, char c) {
                                   return acc + letter_value(c);
                               });
    };

    auto score_at = [&names, &name_value](std::size_t index) {
        return static_cast<long long>(index + 1) * name_value(names[index]);
    };

    long long total = 0;
    for (std::size_t i = 0; i < names.size(); ++i) {
        total += score_at(i);
    }

    return total;
}

result euler() {
    const auto start = std::chrono::steady_clock::now();
    long long value = evaluate();
    const auto end = std::chrono::steady_clock::now();
    long long elapsed = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();
    return {value, elapsed};
}

int main() {
    std::cout << "Project Euler Problem 22 (lambda)" << std::endl;
    result r = euler();
    std::cout << "Result: " << r.value << std::endl;
    std::cout << "Evaluation time: " << r.time_ns << " ns" << std::endl;
    return 0;
}