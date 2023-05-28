name := "Scala3Euler"
version := "1.0"
scalaVersion := "3.2.2"

// Define your library dependencies here
libraryDependencies ++= Seq(
  // Example dependency: ScalaTest
  "org.scalatest" %% "scalatest" % "3.2.9" % Test
)

// do i need to add anything for metals
// https://scalameta.org/metals/docs/build-tools/sbt.html
// addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.3")
// Additional settings for your project
// For example, if you're using the sbt-assembly plugin for creating a fat JAR:
// addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "1.2.0")

// Define any custom tasks or configurations here
// For example, if you want to define a custom "runAll" task:
// lazy val runAll = taskKey[Unit]("Runs all tasks")
// runAll := (compile in Compile).value
// Add `runAll` to the `test` and `run` tasks: (test in Test) := (test in Test).dependsOn(runAll)
// run := (run in Compile).dependsOn(runAll).evaluated
