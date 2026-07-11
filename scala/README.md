# Scala Euler Solutions

This folder contains standalone Scala solutions for Project Euler problems.

## Prerequisites

- Scala 3 toolchain installed (`scalac`, `scala`)
- Optional: sbt (project file exists as `build.sbt`)

## Folder Layout

- Problem files: `problem1.scala`, `problem2.scala`, ...
- Template file: `problemN.template.scala`
- Build definition: `build.sbt`

Most problem files define an object with a `main` method (for example `object problem1`), so they can be compiled and run directly.

## Quick Start (Direct Scala)

From the `scala` folder:

```sh
cd scala
scala run problem1.scala
```

Run another one the same way:

```sh
scala run problem22.scala
```

This keeps build artifacts out of the source folder by default.

## Optional: Use `scalac` with an Isolated Output Folder

If you want to compile with `scalac`, send class files to a build folder:

```sh
mkdir -p build-local/scala-classes
scalac -d build-local/scala-classes problem1.scala
```

## Clean Compiled Artifacts

If you previously compiled in-place, clean generated files with:

```sh
find . -name "*.class" -delete
find . -name "*.tasty" -delete
```

## sbt Notes

An sbt project file exists (`build.sbt`), but the current solutions are flat files in this folder rather than the usual `src/main/scala` layout.

If you want to run everything through sbt conventions, move problem files under `src/main/scala` and then use:

```sh
sbt compile
sbt "runMain problem1"
```

## Add A New Problem

Use the template file to create a new solution quickly:

```sh
cd scala
cp problemN.template.scala problem23.scala
```

Then edit `problem23.scala`:

- Rename `object problemN` to `object problem23`
- Update the header comment and problem URL
- Implement `answer`

Compile and run:

```sh
scala run problem23.scala
```

## Tips

- Keep one object name per file that matches the file intention (for example `problem14` in `problem14.scala`).
- For benchmark or timing output, keep printing in each file's `main` method so each problem remains runnable on its own.
