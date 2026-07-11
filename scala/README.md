# Scala Euler Solutions

This folder contains standalone Scala solutions for Project Euler problems.

## Prerequisites

- Scala 3 toolchain installed (`scalac`, `scala`)
- Optional: sbt (project file exists as `build.sbt`)

## Folder Layout

- Problem files: `problem1.scala`, `problem2.scala`, ...
- Build definition: `build.sbt`

Most problem files define an object with a `main` method (for example `object problem1`), so they can be compiled and run directly.

## Quick Start (Direct Scala)

From the `scala` folder:

```sh
cd scala
scalac problem1.scala
scala problem1
```

Run another one the same way:

```sh
scalac problem22.scala
scala problem22
```

## Clean Compiled Class Files

If you compile directly with `scalac`, remove generated `.class` files with:

```sh
find . -name "*.class" -delete
```

## sbt Notes

An sbt project file exists (`build.sbt`), but the current solutions are flat files in this folder rather than the usual `src/main/scala` layout.

If you want to run everything through sbt conventions, move problem files under `src/main/scala` and then use:

```sh
sbt compile
sbt "runMain problem1"
```

## Tips

- Keep one object name per file that matches the file intention (for example `problem14` in `problem14.scala`).
- For benchmark or timing output, keep printing in each file's `main` method so each problem remains runnable on its own.
