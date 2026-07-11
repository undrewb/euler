cmake_minimum_required(VERSION 3.20)

# Project name
project(euler)

# Set C++ standard to C++20
set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Create executable
add_executable(problem1 problem1.cpp)
add_executable(problem2 problem2.cpp)
add_executable(problem3 problem3.cpp)
add_executable(problem4 problem4.cpp)
add_executable(problem5 problem5.cpp)
add_executable(problem6 problem6.cpp)
add_executable(problem7 problem7.cpp)
add_executable(problem8 problem8.cpp)
add_executable(problem8-functional problem8-functional.cpp)
add_executable(problem8-functional-hybrid problem8-functional-hybrid.cpp)
add_executable(problem9 problem9.cpp)
add_executable(problem10 problem10.cpp)
add_executable(problem11 problem11.cpp)
add_executable(problem12 problem12.cpp)
add_executable(problem13 problem13.cpp)
add_executable(problem14 problem14.cpp)
add_executable(problem15 problem15.cpp)
add_executable(problem16 problem16.cpp)
add_executable(problem17 problem17.cpp)
add_executable(problem18 problem18.cpp)
add_executable(problem19 problem19.cpp)
add_executable(problem20 problem20.cpp)
add_executable(problem21 problem21.cpp)
add_executable(problem22 problem22.cpp)

# For multi-file projects with headers and separate .cpp files
# add_executable(rooster main.cpp dog.cpp dog.h cat.cpp cat.h)
