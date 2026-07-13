/*
https://projecteuler.net/problem=N

Problem N title

TODO:
- Replace "Problem N title" with the official Project Euler title.
- Copy the full official problem description into this header comment.
- Implement evaluate() to return the final answer.
*/

#include <chrono>
#include <iostream>
using namespace std;

struct result {
    int value;
    long long time_ns;
};

int evaluate() {
    // TODO: implement problem logic.
    return -1;
}

result euler() {
    const auto start = std::chrono::steady_clock::now();
    int value = evaluate();
    const auto end = std::chrono::steady_clock::now();
    long long elapsed = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();
    return {value, elapsed};
}

int main() {
    std::cout << "Project Euler Problem N" << std::endl;
    result r = euler();
    std::cout << "Result: " << r.value << std::endl;
    std::cout << "Evaluation time: " << r.time_ns << " ns" << std::endl;
    return 0;
}
