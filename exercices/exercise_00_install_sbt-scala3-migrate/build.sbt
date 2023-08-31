lazy val main = project
  .in(file("."))
  .enablePlugins(BuildInfoPlugin)
  .settings(
    scalaVersion := "2.13.11",
    scalacOptions ++= Seq(
      "-encoding",
      "UTF-8",
      "-target:jvm-1.8",
      "-Xsource:3",
      "-Wunused:imports,privates,locals",
      "-explaintypes"
    ),
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.4.0",
      "io.github.java-diff-utils" % "java-diff-utils" % "4.12",
      "org.scalameta" %% "parsers" % "4.8.9",
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "org.scalameta" %% "munit" % "0.7.23" % Test,
      "com.softwaremill.scalamacrodebug" %% "macros" % "0.4.1" % Test
    ),
    addCompilerPlugin(("org.typelevel" %% "kind-projector" % "0.13.2").cross(CrossVersion.full)),
    addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
    buildInfoKeys += BuildInfoKey(scalacOptions),
    buildInfoPackage := "example",
    Test / testOptions += Tests.Argument(TestFrameworks.MUnit, "+l"),
    Test / parallelExecution := false
  )
