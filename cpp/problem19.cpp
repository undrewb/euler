/*
https://projecteuler.net/problem=19

Counting Sundays

How many Sundays fell on the first of the month during the twentieth century
(1 Jan 1901 to 31 Dec 2000)?
*/

#include <chrono>
#include <iostream>
using namespace std;

struct result {
    long long value;
    long long time_ns;
};

bool is_leap(int y) {
    if (y % 400 == 0) return true;
    if (y % 100 == 0) return false;
    return y % 4 == 0;
}

int days_in_month(int y, int m) {
    static const int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    if (m == 2) {
        return days[1] + (is_leap(y) ? 1 : 0);
    }
    return days[m - 1];
}

long long evaluate_baseline() {
    int day_of_week = 1;
    long long count = 0;

    for (int year = 1900; year <= 2000; ++year) {
        for (int month = 1; month <= 12; ++month) {
            if (year >= 1901 && day_of_week == 0) {
                ++count;
            }
            day_of_week = (day_of_week + days_in_month(year, month)) % 7;
        }
    }

    return count;
}

int day_of_week_sakamoto(int y, int m, int d) {
    static int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
    if (m < 3) y -= 1;
    return (y + y / 4 - y / 100 + y / 400 + t[m - 1] + d) % 7;
}

long long evaluate_optimized() {
    long long count = 0;

    for (int y = 1901; y <= 2000; ++y) {
        for (int m = 1; m <= 12; ++m) {
            if (day_of_week_sakamoto(y, m, 1) == 0) {
                ++count;
            }
        }
    }

    return count;
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
    std::cout << "Project Euler Problem 19" << std::endl;

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
