# Project Euler Solutions

Solutions to Project Euler problems, implemented in two independent languages. Each
problem is a self-contained program that computes and prints its own answer.

## Repository Layout

- `cpp/` — C++20 solutions, built with CMake.
- `scala/` — Scala 3 solutions, run as standalone files (an sbt project also exists).

The two trees are independent: they share no build system or code, just the problem set.

## C++ (`cpp/`)

- Sources: `problem1.cpp`, `problem2.cpp`, ... (some have variants like
  `problem1-functional.cpp`, `problem8-functional-hybrid.cpp`).
- Standard: C++20 (`set(CMAKE_CXX_STANDARD 20)` in `CMakeLists.txt`).
- Every executable must be registered in `CMakeLists.txt` via `add_executable`.

Build and run:

```sh
cd cpp
cmake -S . -B build
cmake --build build
./build/problem1
```

Build a single target: `cmake --build build --target problem8`.

Add a new problem: create `problemN.cpp`, then add
`add_executable(problemN problemN.cpp)` to `CMakeLists.txt` and rebuild.

Notes:
- `build/` and `build-local/` are build output — do not commit binaries.
- `build-local/compile_commands.json` backs clangd IntelliSense; regenerate it
  (re-run CMake) after adding files so editor tooling stays in sync.
- `problem22` reads `0022_names.txt` from the `cpp/` folder.

## Scala (`scala/`)

- Sources: `problem1.scala`, `problem2.scala`, ... plus template
  `problemN.template.scala`.
- Scala 3 (`scalaVersion := "3.3.0"` in `build.sbt`).
- Most files define an `object problemN` with a `main` method so they run directly.

Run directly (preferred, keeps artifacts out of the source folder):

```sh
cd scala
scala run problem1.scala
```

Add a new problem: `cp problemN.template.scala problemN.scala`, rename the object to
`problemN`, update the header/URL, implement `answer`.

Notes:
- Solutions are flat files, not the usual `src/main/scala` layout; running via
  `scala run <file>` matches the current setup rather than `sbt runMain`.
- Keep timing/print output in each file's `main` so problems stay individually runnable.

## Conventions

- One problem per file; keep each solution runnable on its own.
- Match object/file naming to the problem number (e.g. `problem14` in `problem14.scala`).
- Per-language details live in `cpp/README.md` and `scala/README.md`.

## No-Spoiler Workflow

- Do not provide final numeric Project Euler answers unless explicitly requested.
- Default to hint-first support: decomposition, checks, and review feedback.
- Avoid dumping full solutions unless explicitly requested.
- Prefer baseline-first, then optimized iteration with measured comparison.
