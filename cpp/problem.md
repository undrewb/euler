# Problem Workflow

Use this guide to add and run a new Project Euler problem in this repository.

## Files
- Ready file for the next problem: [problem4.cpp](problem4.cpp)
- Generic template: [problemN.template.cpp](problemN.template.cpp)
- Learnings log: [learnings.md](learnings.md)

## How To Use The Generic Template
1. Copy [problemN.template.cpp](problemN.template.cpp) to a new file named `problemX.cpp`.
2. Replace `N` and placeholders in the header comment.
3. Implement `evaluate()`.
4. Update the `Project Euler Problem N` print string.

## Register The New Problem In CMake
Add a line to [CMakeLists.txt](CMakeLists.txt):

```cmake
add_executable(problemX problemX.cpp)
```

## Optional VS Code Wiring
If you want F5 support for the new problem, add:
- a `Build problemX` task in [.vscode/tasks.json](.vscode/tasks.json)
- a `Debug problemX` launch config in [.vscode/launch.json](.vscode/launch.json)

## Build And Run
```sh
cmake --build build --target problemX
./build/problemX
```

## After Solving
Add a short note to [learnings.md](learnings.md) with:
- Goal
- Approach
- Result
- Key learning
- Timing notes (if compared)
