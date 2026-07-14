# Project Euler Solutions

Solutions to [Project Euler](https://projecteuler.net/) problems, implemented in **two
independent languages**. Each problem is a self-contained program that computes and prints
its own answer — no shared framework, no cross-file dependencies.

The point isn't just the answers. It's solving the same problems twice, in two paradigms,
and comparing what each language makes natural: tight imperative C++ versus expressive
functional Scala, with several problems explored in multiple styles (imperative, functional,
lambda-heavy) side by side.

## Repository Layout

```
euler/
├── cpp/      C++20 solutions, built with CMake
├── scala/    Scala 3 solutions, run as standalone files
└── CLAUDE.md Contributor conventions and workflow
```

The two trees are fully independent — they share no build system or code, only the problem
set. Each has its own detailed README:

- [`cpp/README.md`](cpp/README.md) — CMake build, running targets, adding problems
- [`scala/README.md`](scala/README.md) — running via `scala run`, sbt notes, adding problems

## Quick Start

### C++

```sh
cd cpp
cmake -S . -B build
cmake --build build
./build/problem1
```

Build a single target with `cmake --build build --target problem8`.

### Scala

```sh
cd scala
scala run problem1.scala
```

Running via `scala run <file>` keeps build artifacts out of the source folder.

## Solution Variants

Some problems are solved more than once to contrast approaches:

- **C++** — e.g. `problem1.cpp`, `problem1-functional.cpp`, `problem1-lambda.cpp`;
  `problem8.cpp`, `problem8-functional.cpp`, `problem8-functional-hybrid.cpp`,
  `problem8-lambda.cpp`.
- **Scala** — e.g. `problem3.scala` / `problem3a.scala`, plus assorted explorations
  (`sudoku.scala`, `stockPrices.scala`, `tripleProducts.scala`).

## Adding a Problem

Both trees include a template to copy from:

| Language | Template | New file |
|----------|----------|----------|
| C++ | `problemN.template.cpp` | `problemN.cpp` + `add_executable` in `CMakeLists.txt` |
| Scala | `problemN.template.scala` | `problemN.scala` (rename the `object` to match) |

For each new problem, copy the official Project Euler title and full description into the
file's header comment block from `https://projecteuler.net/problem=N`.

## Conventions

- One problem per file; every solution is runnable on its own.
- File and object names match the problem number (e.g. `problem14` in `problem14.scala`).
- Keep timing/print output in each program's entry point so problems stay individually runnable.
- `build/` and `build-local/` (C++) hold build output and are never committed.

See [`CLAUDE.md`](CLAUDE.md) for the full contributor workflow.

## A Note on Spoilers

This repo contains worked solutions and final answers. If you're working through Project
Euler yourself, the strong recommendation is to solve each problem before reading the code
here — the fun is in the figuring out.
