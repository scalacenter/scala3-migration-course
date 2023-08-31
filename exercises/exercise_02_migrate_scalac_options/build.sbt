lazy val main = project
  .in(file("."))
  .enablePlugins(BuildInfoPlugin)
  .settings(
    scalaVersion := "2.13.11",
    scalacOptions ++= {
      val sharedOptions = Seq(
        "-encoding",
        "UTF-8",
        "-target:jvm-1.8",
        "-Xsource:3",
        "-Wunused:imports,privates,locals",
        "-explaintypes"
      )
      if (scalaVersion.value.startsWith("3.")) sharedOptions :+ "-Ykind-projector"
      else sharedOptions
    },
    libraryDependencies ++= {
      val sharedDependencies = Seq(
        "org.typelevel" %% "cats-core" % "2.6.1",
        "io.github.java-diff-utils" % "java-diff-utils" % "4.12",
        ("org.scalameta" %% "parsers" % "4.8.9").cross(CrossVersion.for3Use2_13),
        "org.scala-lang" % "scala-reflect" % "2.13.11",
        "org.scalameta" %% "munit" % "0.7.25" % Test
      )
      val kindProjectorPlugin =
        compilerPlugin("org.typelevel" %% "kind-projector" % "0.13.2").cross(CrossVersion.full)
      if (scalaVersion.value.startsWith("3.")) sharedDependencies
      else sharedDependencies :+ kindProjectorPlugin
    },
    buildInfoKeys += BuildInfoKey(scalacOptions),
    buildInfoPackage := "example",
    Test / testOptions += Tests.Argument(TestFrameworks.MUnit, "+l"),
    Test / parallelExecution := false
  )
