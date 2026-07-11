# C++ Euler Solutions

This folder contains C++ implementations for Project Euler problems, built with CMake.

## Prerequisites

- CMake 3.20+
- A C++20 compiler
  - Apple Clang on macOS
  - GCC 10+
  - Clang 12+

## Project Layout

- Problem sources: `problem1.cpp`, `problem2.cpp`, ...
- Build config: `CMakeLists.txt`
- Build output directory: `build/` (ignored by git)

## Build

Run these commands from the cpp folder:

```sh
cd cpp
cmake -S . -B build
cmake --build build
```

This builds all registered executables in `CMakeLists.txt`.

## Run

Run a specific problem executable:

```sh
./build/problem1
./build/problem22
```

On Windows (PowerShell):

```powershell
.\build\problem1.exe
```

## Build And Run One Problem

If you only want one target:

```sh
cd cpp
cmake -S . -B build
cmake --build build --target problem8
./build/problem8
```

## Add A New Problem

1. Copy `problemN.template.cpp` to a new file like `problem23.cpp`.
2. Add a target in `CMakeLists.txt`:

```cmake
add_executable(problem23 problem23.cpp)
```

3. Rebuild:

```sh
cmake --build build --target problem23
```

4. Run:

```sh
./build/problem23
```

## Notes

- Keep runtime artifacts in `build/`; do not commit binaries.
- `problem22` expects `0022_names.txt` to be present in this folder.
