/*
https://projecteuler.net/problem=24

Lexicographic permutations

A permutation is an ordered arrangement of objects. For example, 3124 is one
possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are
listed numerically or alphabetically, we call it lexicographic order. The
lexicographic permutations of 0, 1 and 2 are:

012 021 102 120 201 210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5,
6, 7, 8 and 9?

No-spoiler scaffold:
- Keep baseline and optimized paths separate.
- Measure both.
- Do not hardcode or print known final answers.
*/

#include <chrono>
#include <iostream>

using namespace std;

struct result {
    long long value;
    long long time_ns;
};

bool next_permutation_manual(int digits[], int n) {
    int pivot = n - 2;
    while (pivot >= 0 && digits[pivot] >= digits[pivot + 1]) {
        --pivot;
    }

    if (pivot < 0) {
        return false;
    }

    int successor = n - 1;
    while (digits[successor] <= digits[pivot]) {
        --successor;
    }

    int tmp = digits[pivot];
    digits[pivot] = digits[successor];
    digits[successor] = tmp;

    int left = pivot + 1;
    int right = n - 1;
    while (left < right) {
        int t = digits[left];
        digits[left] = digits[right];
        digits[right] = t;
        ++left;
        --right;
    }

    return true;
}

long long evaluate_baseline() {
    // Brute-force baseline: iterate lexicographic permutations one-by-one.
    int digits[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int count = 0;
    do {
        count++;
        if (count == 1000000) {
            long long result = 0;
            for (int i = 0; i < 10; ++i) {
                result = result * 10 + digits[i];
            }
            return result;
        }
    } while (next_permutation_manual(digits, 10));
    return -1; // Should never reach here if the logic is correct   
}

long long evaluate_optimized() {
    const int target_1_based = 1000000;
    int target_index = target_1_based - 1;

    int factorial[11];
    factorial[0] = 1;
    for (int i = 1; i <= 10; ++i) {
        factorial[i] = factorial[i - 1] * i;
    }

    int available[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int available_count = 10;

    long long result = 0;
    for (int remaining = 9; remaining >= 0; --remaining) {
        int block_size = factorial[remaining];
        int pick_index = target_index / block_size;
        target_index %= block_size;

        int digit = available[pick_index];
        result = result * 10 + digit;

        for (int i = pick_index; i < available_count - 1; ++i) {
            available[i] = available[i + 1];
        }
        --available_count;
    }

    return result;
}

result euler_baseline() {
    const auto start = chrono::steady_clock::now();
    long long value = evaluate_baseline();
    const auto end = chrono::steady_clock::now();
    long long elapsed = chrono::duration_cast<chrono::nanoseconds>(end - start).count();
    return {value, elapsed};
}

result euler() {
    const auto start = chrono::steady_clock::now();
    long long value = evaluate_optimized();
    const auto end = chrono::steady_clock::now();
    long long elapsed = chrono::duration_cast<chrono::nanoseconds>(end - start).count();
    return {value, elapsed};
}

int main() {
    cout << "Project Euler Problem 24" << endl;

    result baseline = euler_baseline();
    result optimized = euler();

    cout << "Result (baseline): " << baseline.value << endl;
    cout << "Time (baseline): " << baseline.time_ns << " ns" << endl;
    cout << "Result (optimized): " << optimized.value << endl;
    cout << "Time (optimized): " << optimized.time_ns << " ns" << endl;

    if (optimized.time_ns > 0) {
        double speedup = static_cast<double>(baseline.time_ns) / static_cast<double>(optimized.time_ns);
        cout << "Speedup: " << speedup << "x" << endl;
    }

    return 0;
}