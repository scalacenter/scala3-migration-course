# Migrating the library dependencies and compiler plugins

One of the hardest an most important task of the migration is to update the
library dependencies.

A large part of the ecosystem has already been ported to Scala 3. Consequently,
for most dependencies, updating them to Scala 3, is as simple as bumping their
version number.

Many of the other Scala 2.13 dependencies can be used in Scala 3 in a source and
binary compatible way, using the new and special `for3Use2_13` cross version in
sbt.

But, for the macro libraries or for the compiler plugins it is a different
story. Scala 3 introduces a new principled approach of metaprogramming that is
safer than Scala 2 and easier to maintain. As a consequence the macro libraries
need to be completely rewritten from the ground up by their authors and
maintainers. A few macro libraries will not be ported to Scala 3. The same goes
for compiler plugins. For you it means you won't be able to update a few of your
dependencies and you will need to remove them from your build. Hopefully,
removing those dependencies should not be hard enough to prevent you from moving
to Scala 3.

## Steps

1. Run `migrateDependencies main` to learn how to update the dependencies of
   your build.

It should outputs:

```shell
sbt:main> migrateDependencies main
[info] 
[info] Starting migration of libraries and compiler plugins of project main
[info] 
[info] Valid dependencies:
[info] "io.github.java-diff-utils" % "java-diff-utils" % "4.12"
[info] "org.scala-lang" % "scala-reflect" % "2.13.11"
[warn] 
[warn] Versions to update:
[warn] "org.typelevel" %% "cats-core" % "2.6.1" (Other versions: 2.7.0, ..., 2.10.0)
[warn] "org.scalameta" %% "munit" % "0.7.25" % Test (Other versions: 0.7.26, ..., 1.0.0-M8)
[warn] 
[warn] For Scala 3 use 2.13:
[warn] ("org.scalameta" %% "parsers" % "4.8.9").cross(CrossVersion.for3Use2_13)
[warn] 
[warn] Integrated compiler plugins:
[warn] addCompilerPlugin(("org.typelevel" %% "kind-projector" % "0.13.2").cross(CrossVersion.full))
[warn] replaced by scalacOptions += "-Ykind-projector"
[error] 
[error] Incompatible Libraries:
[error] "com.softwaremill.scalamacrodebug" %% "macros" % "0.4.1" % Test (Macro Library)
[error] addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1") (Compiler Plugin)
[info] 
[success] Total time: 1 s, completed Sep 4, 2023 11:39:34 AM
```

2. The `java-diff-utils` dependency is already valid because it is a Java
   dependency.

3. Update the `cats-core` and `munit` versions.

4. The Scalameta's `parsers` library has not yet been published to Scala 3. But
   you can use `.cross(CrossVersion.for3Use2_13)`.

5. The `kind-projector` plugin has been integrated in the Scala 3 compiler
   itself. You need to replace the dependency by a compiler option.

During the migration process, it is important to maintain the compatibility with
Scala 2.13. The later `migrateSyntax` and `migrateTypes` commands will use the
Scala 2.13 compilation to rewrite some parts of the code automatically.

You can configure `kind-projector` in a cross-compatible way like this:

```scala
// add kind-projector as a dependency on Scala 2
libraryDependencies ++= {
  if (scalaVersion.value.startsWith("3.")) Seq.empty
  else Seq(
    compilerPlugin(("org.typelevel" %% "kind-projector" % "0.13.2").cross(CrossVersion.full))
  )
},
// activate kind-projector in Scala 3
scalacOptions ++= {
  if (scalaVersion.value.startsWith("3.")) Seq("-Ykind-projector")
  else Seq.empty
}
```

6. `scalamacrodebug` is a macro library that has not yet been ported to Scala 3.
   Remove it from the build. Reload the build and try to compile the main code
   and the test code. You should see some compilation errors.
   
   It seems we used `scalamacrodebug` to print some debug info about the code.
   You can safely remove those lines of code without altering the logic of the
   program.

7. `better-monadic-for` is a compiler plugin that will not be ported to Scala 3.
   (Some part of it has been integrated in the compiler itself but not all of
   it.) As for `scalamacrodebug`, remove it from the build, reload, compile and
   fix the errors.
   
   You cannot remove the erroneous line without altering the logic of the
   program. You need to add some code to fix it.

8. Check that you can still run the tests in Scala 2.13.

9. To check that sbt can resolve the Scala 3 dependencies you can run:

```
sbt:main> ++3.3.0!
sbt:main> main/update
sbt:main> reload
```

10. If all 3 commands succeeds, you can commit your changes:

```shell
> git commit -a -m 'Migrate dependencies to Scala 3'
```

Go to the next exercise by running `cmtc next-exercise` in a terminal.
