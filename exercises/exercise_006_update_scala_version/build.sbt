lazy val main = project
  .in(file("."))
  .enablePlugins(BuildInfoPlugin)
  .settings(
    scalaVersion := "3.3.0",
    scalacOptions ++= Seq(
      "-encoding",
      "UTF-8",
      "-Wunused:imports,privates,locals",
      "-Xunchecked-java-output-version:8",
      "-explain",
      "-Ykind-projector"),
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.6.1",
      "io.github.java-diff-utils" % "java-diff-utils" % "4.12",
      ("org.scalameta" %% "parsers" % "4.8.9").cross(CrossVersion.for3Use2_13),
      "org.scala-lang" % "scala-reflect" % "2.13.11",
      "org.scalameta" %% "munit" % "0.7.25" % Test),
    buildInfoKeys += BuildInfoKey(scalacOptions),
    buildInfoPackage := "example",
    Test / testOptions += Tests.Argument(TestFrameworks.MUnit, "+l"),
    Test / parallelExecution := false)
