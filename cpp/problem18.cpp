/*
https://projecteuler.net/problem=18

Maximum path sum I

Find the maximum total from top to bottom of the triangle.
*/

#include <algorithm>
#include <chrono>
#include <iostream>
#include <vector>
using namespace std;

struct result {
    long long value;
    long long time_ns;
};

std::vector<std::vector<int>> triangle() {
    return {
        {75},
        {95, 64},
        {17, 47, 82},
        {18, 35, 87, 10},
        {20, 4, 82, 47, 65},
        {19, 1, 23, 75, 3, 34},
        {88, 2, 77, 73, 7, 63, 67},
        {99, 65, 4, 28, 6, 16, 70, 92},
        {41, 41, 26, 56, 83, 40, 80, 70, 33},
        {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
        {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
        {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
        {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
        {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
        {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}};
}

int dfs_max(const std::vector<std::vector<int>> &tri, int r, int c) {
    if (r == static_cast<int>(tri.size()) - 1) {
        return tri[r][c];
    }
    int left = dfs_max(tri, r + 1, c);
    int right = dfs_max(tri, r + 1, c + 1);
    return tri[r][c] + std::max(left, right);
}

long long evaluate_baseline() {
    auto tri = triangle();
    return dfs_max(tri, 0, 0);
}

long long evaluate_optimized() {
    auto tri = triangle();

    for (int r = static_cast<int>(tri.size()) - 2; r >= 0; --r) {
        for (int c = 0; c <= r; ++c) {
            tri[r][c] += std::max(tri[r + 1][c], tri[r + 1][c + 1]);
        }
    }

    return tri[0][0];
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
    std::cout << "Project Euler Problem 18" << std::endl;

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
